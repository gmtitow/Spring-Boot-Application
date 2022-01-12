package com.example.demo.maven.controller.authentication.response;

import com.example.demo.maven.Response;
import com.example.demo.maven.model.User;

public class RegisterResponse extends Response {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
