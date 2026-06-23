package com.example.Spring_Testing_exercise.Service;

import com.example.Spring_Testing_exercise.Entity.User;
import com.example.Spring_Testing_exercise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }
}
