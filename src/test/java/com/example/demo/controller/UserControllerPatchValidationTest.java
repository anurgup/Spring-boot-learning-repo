package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerPatchValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void patchUser_withAgeLessThan21_returnsBadRequest() throws Exception {
        Map<String, Object> updates = Map.of("age", 18);

        mockMvc.perform(patch("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updates)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Age cannot be less than 21 years"));
    }

    @Test
    public void patchUser_withAgeExactly21_returnsOk() throws Exception {
        Map<String, Object> updates = Map.of("age", 21);
        User updatedUser = new User(1L, "John", "john@example.com", 21);
        when(userService.patchUser(eq(1L), any())).thenReturn(Optional.of(updatedUser));

        mockMvc.perform(patch("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updates)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value(21));
    }

    @Test
    public void patchUser_withAgeGreaterThan21_returnsOk() throws Exception {
        Map<String, Object> updates = Map.of("age", 30);
        User updatedUser = new User(1L, "John", "john@example.com", 30);
        when(userService.patchUser(eq(1L), any())).thenReturn(Optional.of(updatedUser));

        mockMvc.perform(patch("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updates)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value(30));
    }

    @Test
    public void patchUser_withAge20_returnsBadRequest() throws Exception {
        Map<String, Object> updates = Map.of("age", 20);

        mockMvc.perform(patch("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updates)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Age cannot be less than 21 years"));
    }

    @Test
    public void patchUser_withNoAge_returnsOk() throws Exception {
        Map<String, Object> updates = Map.of("name", "Jane");
        User updatedUser = new User(1L, "Jane", "jane@example.com", 25);
        when(userService.patchUser(eq(1L), any())).thenReturn(Optional.of(updatedUser));

        mockMvc.perform(patch("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updates)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane"));
    }

    @Test
    public void patchUser_withUserNotFound_returnsNotFound() throws Exception {
        Map<String, Object> updates = Map.of("age", 25);
        when(userService.patchUser(eq(99L), any())).thenReturn(Optional.empty());

        mockMvc.perform(patch("/users/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updates)))
                .andExpect(status().isNotFound());
    }
}
