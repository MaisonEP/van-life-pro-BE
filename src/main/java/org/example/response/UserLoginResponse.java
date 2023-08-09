package org.example.response;

import java.util.UUID;

public class UserLoginResponse {

    private UUID userId;
    private String username;

    public UserLoginResponse(UUID userId, String username) {
        this.userId = userId;
        this.username = username;
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
}
