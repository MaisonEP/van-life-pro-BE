package org.example.controller;

import org.example.DBModel.posts.Post;
import org.example.DBModel.posts.PostsRepository;
import org.example.DBModel.users.UserAccountRepository;
import org.example.DBModel.users.Users;
import org.example.requests.CreatePostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private UserAccountRepository userAccountRepository;
    private PostsRepository postsRepository;

    public  PostsController(UserAccountRepository userAccountRepository, PostsRepository postsRepository){
        this.userAccountRepository = userAccountRepository;
        this.postsRepository=postsRepository;
    }


    @PostMapping("/create")
    public void createPost(@RequestBody CreatePostRequest createPostRequest){
        Users user = userAccountRepository.getReferenceById(createPostRequest.getUserId());
        Post post;
        if( createPostRequest.getIsLocation().isPresent() ){
            post = new Post(user, createPostRequest.getTitle(), createPostRequest.getContent(), createPostRequest.getIsLocation().get());
        } else {
            post = new Post(user, createPostRequest.getTitle(), createPostRequest.getContent());
        }

        postsRepository.save(post);
    }

    @GetMapping
    public List<Post> getPosts() {
        return postsRepository.findAll();
    }
}
