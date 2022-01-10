package com.example.demo.maven.controller;

import com.example.demo.maven.model.Greeting;
import com.example.demo.maven.model.User;
import com.example.demo.maven.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam(value = "login") String login,
                                      @RequestParam(value = "password") String password) {
        User result = service.login(login, password);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/register")
    public ResponseEntity<?> register(@RequestParam(value = "login") String login,
                                   @RequestParam(value = "password") String password) {
        User result = service.register(login, password);
        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
