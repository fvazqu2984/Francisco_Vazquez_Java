package com.company.Summative1TarikuHewan.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Magic8BallController.class)
public class Magic8BallControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getAnswerTest() throws Exception {
        String question = "Will I have a good day?";

        mockMvc.perform(post("/magic")
                        .content(question)
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.question").value(question))
                .andExpect(jsonPath("$.answer").isString());
    }
}
