package com.capstone.project.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.project.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);  // 🔥 MUST EXIST
}