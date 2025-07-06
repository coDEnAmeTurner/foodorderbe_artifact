package com.foodorderbe.foodorderbe_artifact.responses;

import java.io.Serializable;

import com.foodorderbe.foodorderbe_artifact.entities.User;

public class LoginResp implements Serializable {
    private String token;
    private User user;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LoginResp() {
    }
    public LoginResp(String token, User user) {
        this.token = token;
        this.user = user;
    }
    
    
    
}
