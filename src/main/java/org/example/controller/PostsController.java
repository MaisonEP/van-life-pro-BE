package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.DBModel.posts.Post;
import org.example.DBModel.posts.PostsRepository;
import org.example.DBModel.users.UserAccountRepository;
import org.example.DBModel.users.Users;
import org.example.requests.CreatePostRequest;
import org.example.response.PostResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final UserAccountRepository userAccountRepository;
    private final PostsRepository postsRepository;

    private ObjectMapper objectMapper;

    public  PostsController(UserAccountRepository userAccountRepository, PostsRepository postsRepository, ObjectMapper o){
        this.userAccountRepository = userAccountRepository;
        this.postsRepository=postsRepository;
        this.objectMapper = o;
    }


    @PostMapping("/create")
    public void createPost(@RequestBody CreatePostRequest createPostRequest) throws JsonProcessingException {
        Users user = userAccountRepository.getReferenceById(createPostRequest.getUserId());
        byte[] image = null;
        if (createPostRequest.getFile() != null) {
            Map<String, Object> map = objectMapper.readValue(createPostRequest.getFile(), new TypeReference<Map<String, Object>>() {
            });
        String fileInBase64 = map.get("base64").toString();
        image = fileInBase64.getBytes();
        }
        Post post;
        if( createPostRequest.getIsLocation().isPresent() ){
            post = new Post(user, createPostRequest.getTitle(), createPostRequest.getContent(), createPostRequest.getIsLocation().get(), createPostRequest.getLatitude(), createPostRequest.getLongitude(),image);
        } else {
            post = new Post(user, createPostRequest.getTitle(), createPostRequest.getContent());
        }

        postsRepository.save(post);
    }

    @GetMapping
    public List<PostResponse> getPosts() {
        List<Post> all = postsRepository.findAll();



        return all.stream().map(post -> new PostResponse(
                post.getPostId(),
                post.getUser(),
                post.getTitle(),
                post.getContent(),
                post.getLatitude(),
                post.getLongitude(),
                post.getImage() !=null ? new String(post.getImage()): null,
                post.getLocation()
        )).toList();
    }
}
