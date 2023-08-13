package org.example.requests;

import java.util.UUID;

public class CommentRequest {

    private UUID commentId;

    private String comment;

    private UUID postId;

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

    public CommentRequest(UUID commentId, String comment, UUID postId) {
        this.commentId = commentId;
        this.comment = comment;
        this.postId = postId;
    }
}
