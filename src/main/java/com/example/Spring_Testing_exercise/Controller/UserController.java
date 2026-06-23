package com.example.Spring_Testing_exercise.Controller;

import com.example.Spring_Testing_exercise.Entity.User;
import com.example.Spring_Testing_exercise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/{id}")

    public ResponseEntity<User>getUser(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }
}
