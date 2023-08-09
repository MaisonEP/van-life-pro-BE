package org.example.requests;


import java.util.Optional;
import java.util.UUID;

public class CreatePostRequest {

    private UUID userId;


    private String title;

    private String content;

    private Optional<Boolean> isLocation;


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Optional<Boolean> getIsLocation() {
        return isLocation;
    }

    public void setIsLocation(Optional<Boolean> isLocation) {
        this.isLocation = isLocation;
    }

    public CreatePostRequest(UUID userId, String title, String content, Optional<Boolean> isLocation) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.isLocation = isLocation;
    }
}
