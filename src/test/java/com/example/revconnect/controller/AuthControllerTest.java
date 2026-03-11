package com.example.revconnect.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginSuccess() throws Exception {

        String json = """
        {
		  
		  "email": "user11T@gmail.com",
		  "password": "Password@1234"
   
}
        """;

        mockMvc.perform(post("/api/auth/login")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }

}