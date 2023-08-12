package org.example.DBModel.posts;

import jakarta.persistence.*;
import org.example.DBModel.users.Users;

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

    public Post(Users user, String title, String content, Boolean isLocation, double latitude, double longitude) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.isLocation = isLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Post(Users user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Post(){

    }
}
