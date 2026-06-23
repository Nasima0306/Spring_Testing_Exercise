package com.example.Spring_Testing_exercise.Controller;

import com.example.Spring_Testing_exercise.Controller.UserController;
import com.example.Spring_Testing_exercise.Entity.User;
import com.example.Spring_Testing_exercise.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)

public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserService userService;

    @Test
    void testGetUser() throws Exception {

        User user = new User(1L, "Nasima");

        when(userService.getUserById(1L))
                .thenReturn(user);

        mockMvc.perform(get("/users/1"))

                .andExpect(status().isOk())

                .andExpect(
                        jsonPath("$.name")
                                .value("Nasima")
                );
    }
    }
