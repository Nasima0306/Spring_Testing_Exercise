package com.example.Spring_Testing_exercise.Integration;

import com.example.Spring_Testing_exercise.Entity.User;
import com.example.Spring_Testing_exercise.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserIntegrationTest {
    @Autowired
    UserRepository repository;

    @Test

    void testDatabase() {

        User user =
                new User(1L,"Nasima");

        repository.save(user);

        User result =
                repository.findById(1L)
                        .orElse(null);

        assertNotNull(result);

        assertEquals(
                "Nasima",
                result.getName()
        );
    }
}
