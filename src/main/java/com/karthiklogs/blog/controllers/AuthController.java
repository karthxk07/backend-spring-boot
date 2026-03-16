package com.karthiklogs.blog.controllers;


import com.karthiklogs.blog.payloads.LoginDto;
import com.karthiklogs.blog.payloads.RegisterDto;
import com.karthiklogs.blog.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(authService.Login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(authService.Register(registerDto));
    }
}
