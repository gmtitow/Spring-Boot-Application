package com.example.demo.maven.service;

import com.example.demo.maven.model.User;

public interface AuthenticationService {

    User register(String login, String password);

    User login(String login, String password);
}
