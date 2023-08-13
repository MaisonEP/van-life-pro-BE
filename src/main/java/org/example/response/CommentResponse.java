package org.example.response;

import java.time.Instant;
import java.util.UUID;

public class CommentResponse {

    private UUID commentId;
    private String comment;
    private  UUID postId;

    private String username;

    private Instant timeDate;

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Instant timeDate) {
        this.timeDate = timeDate;
    }

    public CommentResponse(UUID commentId, String comment, UUID postId, String username, Instant timeDate) {
        this.commentId = commentId;
        this.comment = comment;
        this.postId = postId;
        this.username = username;
        this.timeDate = timeDate;
    }
}
