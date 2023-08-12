package org.example.requests;

import java.util.Optional;
import java.util.UUID;

public class CreatePostRequest {

    private UUID userId;


    private String title;

    private String content;

    private double latitude;
    private double longitude;

    private Optional<Boolean> isLocation;

    private String file;
    private String file2;


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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    public CreatePostRequest(UUID userId, String title, String content, Optional<Boolean> isLocation, double latitude, double longitude, String file,  String file2) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.isLocation = isLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.file = file;
        this.file2 = file2;
    }
}
