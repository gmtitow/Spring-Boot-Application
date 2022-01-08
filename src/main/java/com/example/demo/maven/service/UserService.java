package com.example.demo.maven.service;

import com.example.demo.maven.model.User;

import java.util.List;

public interface UserService extends CrudService<User> {

    User getByLogin(String login);
}
