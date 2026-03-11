package com.example.revconnect.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.revconnect.security.JwtAuthenticationFilter;
import com.example.revconnect.security.JwtUtil;
import com.example.revconnect.service.FollowService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FollowController.class)
@AutoConfigureMockMvc(addFilters = false)
public class FollowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FollowService followService;

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    void testFollowUser() throws Exception {

        mockMvc.perform(post("/api/follow/1/2"))
                .andExpect(status().isOk());
    }
}