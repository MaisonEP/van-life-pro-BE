package org.example.requests;

public class UserAccountRequest {

    private String userId;
    private String userName;

    private String password;

    private String file;
    private String file2;

    private String bio;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public UserAccountRequest(String userName, String password, String file, String file2, String userId, String bio) {
        this.userName = userName;
        this.password = password;
        this.file = file;
        this.file2 = file2;
        this.userId = userId;
        this.bio = bio;
    }
}
