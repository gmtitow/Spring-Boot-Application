package com.example.demo.maven.service;

import com.example.demo.maven.model.User;
import com.example.demo.maven.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ACrudServiceImpl<User,UserRepository> implements UserService {
    @Override
    public User getByLogin(String login) {
//        User user = new User();
//        user.setLogin(login);
//
//        Example<User> loginExample = Example.of(user);
//        Optional<User> userFromDB = repository.findOne(loginExample);
        return repository.findByLogin(login);
    }
}

