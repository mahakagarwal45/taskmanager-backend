package com.capstone.project.taskmanager.service;

import com.capstone.project.taskmanager.model.Task;
import com.capstone.project.taskmanager.model.User;
import com.capstone.project.taskmanager.repository.TaskRepository;
import com.capstone.project.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repo;
    private final UserRepository userRepository;


    public Task create(Task t) {

        if (t.getUser() != null && t.getUser().getId() != null) {
            User user = userRepository.findById(t.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            t.setUser(user);
        }

        t.setStatus("PENDING");
        t.setCreatedAt(LocalDateTime.now());
        t.setUpdatedAt(LocalDateTime.now());

        return repo.save(t);
    }

    public List<Task> getUserTasks(Long userId) {
        return repo.findByUserId(userId);
    }

    public Task update(Long id, Task u) {
        Task t = repo.findById(id).orElseThrow();

        t.setTitle(u.getTitle());
        t.setDescription(u.getDescription());
        t.setPriority(u.getPriority());
        t.setDueDate(u.getDueDate());
        t.setStatus(u.getStatus());
        t.setUpdatedAt(LocalDateTime.now());
        return repo.save(t);
    }

        public Task updateStatus(Long id, String status) {
        Task t = repo.findById(id).orElseThrow();

        t.setStatus(status);
        t.setUpdatedAt(LocalDateTime.now());
        return repo.save(t);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}