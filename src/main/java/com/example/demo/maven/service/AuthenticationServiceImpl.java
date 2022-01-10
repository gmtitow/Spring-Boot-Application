package com.example.demo.maven.service;

import com.example.demo.maven.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User register(String login, String password) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(password));
        user.setLogin(login);
        return userService.create(user);
    }

    @Override
    public User login(String login, String password) {

        User user = userService.getByLogin(login);

        if(user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
