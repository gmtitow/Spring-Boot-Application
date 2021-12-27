package com.example.demo.maven.service;

import com.example.demo.maven.model.User;
import com.example.demo.maven.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ACrudServiceImpl<User,UserRepository> implements UserService {
}

