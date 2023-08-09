package org.example.controller;

import jakarta.persistence.EntityManager;
import org.example.DBModel.users.UserAccountRepository;
import org.example.DBModel.users.Users;
import org.example.requests.UserAccountRequest;
import org.example.response.UserLoginResponse;
import org.example.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Users>getAllUser(){
       List<Users> userCredentials = userAccountRepository.findAll();
     return  userCredentials;
    }

    @PostMapping("/accountdetails/verifieduser")
    public UserLoginResponse verifyUser(@RequestBody UserAccountRequest userAccountRequest) throws  Exception {
// create function to check if user credentials exist already in database

        Users user = accountService.login(userAccountRequest);
        UserLoginResponse userWithourPassword = new UserLoginResponse(user.getUserId(), user.getUsername());
        return userWithourPassword;
    }
}
