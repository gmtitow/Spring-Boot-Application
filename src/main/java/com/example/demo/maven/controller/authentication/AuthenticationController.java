package com.example.demo.maven.controller.authentication;

import com.example.demo.maven.ResponseStatus;
import com.example.demo.maven.controller.authentication.request.LoginRequest;
import com.example.demo.maven.controller.authentication.request.RegisterRequest;
import com.example.demo.maven.controller.authentication.response.LoginResponse;
import com.example.demo.maven.controller.authentication.response.RegisterResponse;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User result = service.login(loginRequest.getLogin(),loginRequest.getPassword());

        HttpStatus status;

        LoginResponse response = new LoginResponse();
        if (result == null) {
            response.setStatus(ResponseStatus.ERROR);
            status = HttpStatus.NOT_FOUND;
            response.setErrorInfo(service.getLastError());
        } else {
            response.setStatus(ResponseStatus.OK);
            response.setUser(result);
            status = HttpStatus.OK;
        }

        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        User result = service.register(registerRequest.getLogin(), registerRequest.getPassword());
        HttpStatus status;

        RegisterResponse response = new RegisterResponse();
        if (result == null) {
            response.setStatus(ResponseStatus.ERROR);
            status = HttpStatus.BAD_REQUEST;
            response.setErrorInfo(service.getLastError());
        } else {
            response.setStatus(ResponseStatus.OK);
            response.setUser(result);
            status = HttpStatus.OK;
        }

        return new ResponseEntity<>(response, status);
    }
}
