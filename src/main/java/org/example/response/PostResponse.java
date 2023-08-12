package org.example.response;

import org.example.DBModel.users.Users;

import java.util.UUID;

public class PostResponse {
    private java.util.UUID postId;
    private Users user;

    private String title;

    private String content;

    private double latitude;
    private double longitude;

    private String image;

    private Boolean isLocation = false;

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getLocation() {
        return isLocation;
    }

    public void setLocation(Boolean location) {
        isLocation = location;
    }

    public PostResponse(UUID postId, Users user, String title, String content, double latitude, double longitude, String image, Boolean isLocation) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.isLocation = isLocation;
    }
}
