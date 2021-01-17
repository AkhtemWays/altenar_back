package com.example.demo;

public class UsernameAndPasswordObject {
    String password;
    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsernameAndPasswordObject(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
