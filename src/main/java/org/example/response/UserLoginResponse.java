package org.example.response;

import java.util.UUID;

public class UserLoginResponse {

    private UUID userId;
    private String username;
    private String image;

    private String bio;

    public UserLoginResponse(UUID userId, String username, String image, String bio) {
        this.userId = userId;
        this.username = username;
        this.image = image;
        this.bio = bio;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
