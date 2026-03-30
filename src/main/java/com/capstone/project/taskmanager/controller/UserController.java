package com.capstone.project.taskmanager.controller;

import com.capstone.project.taskmanager.model.Task;
import com.capstone.project.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String test() {
        return "Users API working 🚀";
    }
}