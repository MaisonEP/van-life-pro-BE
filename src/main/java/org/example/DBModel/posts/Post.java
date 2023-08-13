package org.example.DBModel.posts;

import jakarta.persistence.*;
import org.example.DBModel.users.Users;

import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    private String title;

    private String content;

    private double latitude;
    private double longitude;
    @Lob
    private byte[] image;

    @Column(nullable = false)
    private Boolean isLocation = false;

    public Boolean getLocation() {
        return isLocation;
    }

    public void setLocation(Boolean location) {
        isLocation = location;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public UUID getPostId() {
        return postId;
    }

    public Post(Users user, String title, String content, Boolean isLocation, double latitude, double longitude, byte[] image) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.isLocation = isLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }

    public Post(Users user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Post(){

    }
}
