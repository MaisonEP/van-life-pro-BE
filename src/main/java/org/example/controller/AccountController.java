package org.example.controller;

import com.google.common.primitives.Bytes;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.DBModel.users.UserAccountRepository;
import org.example.DBModel.users.Users;
import org.example.requests.UserAccountRequest;
import org.example.response.UserLoginResponse;
import org.example.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountController {


    private UserAccountRepository userAccountRepository;
    private EntityManager entityManager;

    private AccountService accountService;

    public AccountController (EntityManager e, UserAccountRepository U, AccountService a){
        this.entityManager = e;
        this.userAccountRepository = U;
        this.accountService = a;
    }


    @PostMapping("/accountdetails/register")
    public void registerUser(@RequestBody UserAccountRequest userAccountRequest){
      accountService.register(userAccountRequest);
    }

    @GetMapping("/accountdetails/allusers")
    public List<UserLoginResponse>getAllUser(){
       List<Users> userCredentials = userAccountRepository.findAll();
     return  userCredentials.stream().map(user ->  new UserLoginResponse(user.getId(), user.getUsername(), new String(user.getImage()), user.getBio())).toList();
    }

    @GetMapping("/accountdetails/allusers/{userId}")
    @Transactional
    public UserLoginResponse getUserById(@PathVariable UUID userId){
       Users user = userAccountRepository.getReferenceById(userId);
        String image = user.getImage() !=null ? new String(user.getImage()): null;
        return new UserLoginResponse(user.getId(), user.getUsername(), image, user.getBio());
    }

    @Transactional
    @PostMapping("/accountdetails/verifieduser")
    public UserLoginResponse verifyUser(@RequestBody UserAccountRequest userAccountRequest) throws  Exception {
        // create function to check if user credentials exist already in database

        Users user = accountService.login(userAccountRequest);
        UserLoginResponse userWithourPassword = new UserLoginResponse(user.getId(), user.getUsername(), user.getImage() != null ? new String(user.getImage()): null, user.getBio());
        return userWithourPassword;
    }

    @PatchMapping("/accountdetails/profile")
    @Transactional
    public void addProfileImage(@RequestBody UserAccountRequest userAccountRequest) throws  Exception {
        // create function to check if user credentials exist already in database
        byte[] image = null;
        Users user = userAccountRepository.getReferenceById(UUID.fromString(userAccountRequest.getUserId()));
        if (userAccountRequest.getFile() != null) {
            image = Bytes.concat(userAccountRequest.getFile().getBytes(), userAccountRequest.getFile2().getBytes());
            user.setImage(image);
        }

        if(userAccountRequest.getBio() != null){
            user.setBio(userAccountRequest.getBio());
        }

        userAccountRepository.save(user);

    }
}
