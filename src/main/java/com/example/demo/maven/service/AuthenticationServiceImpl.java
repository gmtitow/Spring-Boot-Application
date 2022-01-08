package com.example.demo.maven.service;

import com.example.demo.maven.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    UserService userService;

    @Override
    public User register(User user) {
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        return userService.create(user);
    }

    @Override
    public User login(String login, String password) {

        User user = userService.getByLogin(login);

        if(user != null) {
            if(String.valueOf(password.hashCode()).equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
