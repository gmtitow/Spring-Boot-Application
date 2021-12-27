package com.example.demo.maven.controller;

import com.example.demo.maven.model.User;
import com.example.demo.maven.repository.UserRepository;
import com.example.demo.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController extends ACrudController<User, UserRepository,UserService> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping(value = "/users")
//    public ResponseEntity<?> create(@RequestBody User user) {
//        userService.create(user);
//        return new ResponseEntity<>(user,HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/users")
//    public ResponseEntity<?> read() {
//        final List<User> users = userService.readAll();
//        return users != null &&  !users.isEmpty()
//                ? new ResponseEntity<>(users, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/users/{id}")
//    public ResponseEntity<User> read(@PathVariable(name = "id") Long id) {
//        final User user = userService.read(id);
//
//        return user != null
//                ? new ResponseEntity<>(user, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/users/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody User user) {
//        final User changedUser = userService.update(user, id);
//
//        return changedUser != null
//                ? new ResponseEntity<>(changedUser, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/users/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
//        final boolean deleted = userService.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
}
