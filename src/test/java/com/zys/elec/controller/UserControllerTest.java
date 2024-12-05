package com.zys.elec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateUser() throws Exception {
        String userJson = "{\"username\":\"testuser\",\"password\":\"password123\"}";

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"用户创建成功\"}"));
    }
}