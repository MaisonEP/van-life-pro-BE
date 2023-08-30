package org.example.DBModel.comments;

import jakarta.persistence.*;
import org.example.DBModel.posts.Post;
import org.example.DBModel.users.Users;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String comment;

    @ManyToOne(targetEntity = Post.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", referencedColumnName = "id",  insertable = false, updatable = false)
    private Post post;

    @Column(name = "post_id")
    private UUID postId;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id",  insertable = false, updatable = false)
    private Users user;

    @Column(name = "user_id")
    private UUID userId;

    @CreationTimestamp
    private Instant dateCreated;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Comment(String comment, UUID postId, UUID userId) {
        this.comment = comment;
        this.postId = postId;
        this.userId = userId;
    }


    public Comment() {

    }
}
