package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // Hardcoded demo users
        if ("admin".equals(username) && "password".equals(password)) {
            String token = jwtUtil.generateToken(username, List.of("ROLE_ADMIN"));
            return ResponseEntity.ok(Map.of("token", token));
        } else if ("user".equals(username) && "password".equals(password)) {
            String token = jwtUtil.generateToken(username, List.of("ROLE_USER"));
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
