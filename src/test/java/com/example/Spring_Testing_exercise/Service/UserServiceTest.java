package com.example.Spring_Testing_exercise.Service;

import com.example.Spring_Testing_exercise.Entity.User;
import com.example.Spring_Testing_exercise.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository repository;
    @InjectMocks
    UserService service;
    @Test
    public void testUserById(){
       User user=new User(1L,"Nasima");
       when(repository.findById(1L)).thenReturn(Optional.of(user));
       User result=service.getUserById(1L);
       assertEquals("Nasima",result.getName());
    }

}
