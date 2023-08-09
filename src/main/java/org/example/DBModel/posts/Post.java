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

    public Post(Users user, String title, String content, Boolean isLocation) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.isLocation = isLocation;
    }

    public Post(Users user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Post(){

    }
}
