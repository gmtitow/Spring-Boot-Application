package com.example.demo.maven.service;

import com.example.demo.maven.model.User;

public interface AuthenticationService {

    User register(User user);

    User login(String login, String password);
}
