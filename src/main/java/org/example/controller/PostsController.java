package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Bytes;
import jakarta.transaction.Transactional;
import org.example.DBModel.comments.Comment;
import org.example.DBModel.comments.CommentsRepository;
import org.example.DBModel.posts.Post;
import org.example.DBModel.posts.PostsRepository;
import org.example.DBModel.users.UserAccountRepository;
import org.example.DBModel.users.Users;
import org.example.requests.CommentRequest;
import org.example.requests.CreatePostRequest;
import org.example.response.CommentResponse;
import org.example.response.PostResponse;
import org.example.response.UserLoginResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final UserAccountRepository userAccountRepository;
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;
    private ObjectMapper objectMapper;

    public  PostsController(UserAccountRepository userAccountRepository, PostsRepository postsRepository, ObjectMapper o, CommentsRepository commentsRepository){
        this.userAccountRepository = userAccountRepository;
        this.postsRepository=postsRepository;
        this.objectMapper = o;
        this.commentsRepository = commentsRepository;
    }


    @PostMapping("/create")
    public void createPost(@RequestBody CreatePostRequest createPostRequest) throws JsonProcessingException {
        Users user = userAccountRepository.getReferenceById(createPostRequest.getUserId());
        byte[] image = null;
        if (createPostRequest.getFile() != null) {

        image = Bytes.concat(createPostRequest.getFile().getBytes(), createPostRequest.getFile2().getBytes());
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
                post.getId(),
               new UserLoginResponse(post.getUser().getId(), post.getUser().getUsername(),  post.getUser().getImage() != null ? new String(post.getUser().getImage()): null, post.getUser().getBio()),
                post.getTitle(),
                post.getContent(),
                post.getLatitude(),
                post.getLongitude(),
                post.getImage() !=null ? new String(post.getImage()): null,
                post.getLocation()
        )).toList();
    }

    @PostMapping("/comment")
    @Transactional
    public void addComment(@RequestBody CommentRequest commentRequest) {
        Comment comment = new Comment(commentRequest.getComment(), commentRequest.getPostId(), commentRequest.getUserId());

        commentsRepository.save(comment);
        System.out.println("hello");
    }

    @GetMapping("/comment/{postId}")
    @Transactional
    public List<CommentResponse> getCommentsForPost(@PathVariable UUID postId) {
        List<Comment> allByPostId = commentsRepository.findAllByPostId(postId);

        List<CommentResponse> postComments = new ArrayList<>();
        for (int i = 0; i<allByPostId.size(); i++ ){
            Comment comment = allByPostId.get(i);
            UUID post = comment.getPost().getId();
            String username = comment.getUser().getUsername();

            CommentResponse myCommentResponse = new CommentResponse(comment.getId(), comment.getComment(), post, username, comment.getDateCreated());
            postComments.add(myCommentResponse);
        }
        return postComments;
    }
}
