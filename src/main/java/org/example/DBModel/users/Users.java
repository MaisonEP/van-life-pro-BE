package org.example.DBModel.users;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Users {

    //right Id annotation???
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String username;
    private String password;
    private String bio;


    @Lob
    private byte[] image;

    public UUID getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUserId(java.util.UUID userId){
        this.id = userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Users(String username, String password, byte[] image, String bio) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.bio = bio;
    }

    public Users() {
    }
}
