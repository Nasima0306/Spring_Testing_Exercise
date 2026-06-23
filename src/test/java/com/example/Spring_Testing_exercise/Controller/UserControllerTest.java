package com.example.Spring_Testing_exercise.Controller;

import com.example.Spring_Testing_exercise.Entity.User;
import com.example.Spring_Testing_exercise.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)

public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

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

    @Test
    void testCreateUser() throws Exception {

        User user = new User(1L, "Nasima");

        when(userService.saveUser(any(User.class)))
                .thenReturn(user);

        mockMvc.perform(

                        post("/users")

                                .contentType(
                                        MediaType.APPLICATION_JSON
                                )

                                .content(
                                        objectMapper
                                                .writeValueAsString(user)
                                )

                )

                .andExpect(
                        status().isOk()
                )

                .andExpect(
                        jsonPath("$.name")
                                .value("Nasima")
                );
    }
}