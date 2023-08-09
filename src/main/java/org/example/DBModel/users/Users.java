package org.example.DBModel.users;

import jakarta.persistence.*;

@Entity
@Table
public class Users {

    //right Id annotation???
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID userId;
@Column(unique = true)
    private String username;
    private String password;

    public java.util.UUID getUserId(){
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUserId(java.util.UUID userId){
        this.userId = userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
    }
}
