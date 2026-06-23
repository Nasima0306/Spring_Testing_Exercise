package com.example.Spring_Testing_exercise.Repository;

import com.example.Spring_Testing_exercise.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
