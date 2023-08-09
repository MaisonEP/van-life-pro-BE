package org.example.requests;

public class UserAccountRequest {
    private String userName;

    private String password;


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccountRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
