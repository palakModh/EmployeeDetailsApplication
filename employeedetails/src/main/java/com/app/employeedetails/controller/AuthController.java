package com.app.employeedetails.controller;

import com.app.employeedetails.exception.AppException;
import com.app.employeedetails.request.LoginRequest;
import com.app.employeedetails.request.RegisterationRequest;
import com.app.employeedetails.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee/auth")
public class AuthController {

    @Autowired
    AuthService empService;

    @PostMapping(value = "/register")
    public String register(@RequestBody @Valid RegisterationRequest request) throws AppException {
        return empService.signUp(request);
    }

    @PostMapping(value = "/login")
    public String register(@RequestBody @Valid LoginRequest request) throws AppException {
        return empService.login(request);
    }
}
