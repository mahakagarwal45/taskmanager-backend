package com.capstone.project.taskmanager.controller;

import com.capstone.project.taskmanager.model.User;
import com.capstone.project.taskmanager.repository.UserRepository;
import com.capstone.project.taskmanager.config.JwtUtil;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {

        user.setRole("USER");

        user.setPassword(encoder.encode(user.getPassword()));

        repo.save(user);

        return Map.of("message", "User registered successfully");
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User req) {

        User u = repo.findByEmail(req.getEmail());

        if (u == null) {
            throw new RuntimeException("User not found");
        }

        if (!encoder.matches(req.getPassword(), u.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return Map.of(
                "token", jwtUtil.generateToken(u.getEmail()),
                "id", u.getId(),
                "name", u.getName(),
                "role", u.getRole()
        );
    }

    @GetMapping("/create-admin")
    public String createAdmin() {
        User admin = new User();

        admin.setName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setRole("ADMIN");

        admin.setPassword(encoder.encode("admin123"));

        repo.save(admin);

        return "Admin created";
    }
}