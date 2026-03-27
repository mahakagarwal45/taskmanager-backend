package com.capstone.project.taskmanager.controller;

import com.capstone.project.taskmanager.model.Task;
import com.capstone.project.taskmanager.model.User;
import com.capstone.project.taskmanager.repository.TaskRepository;
import com.capstone.project.taskmanager.repository.UserRepository;
import com.capstone.project.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskService service;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }


    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }
}