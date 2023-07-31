package com.company.Summative1TarikuHewan.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnQuoteAndStatus200() throws Exception {

        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getQuoteOfTheDayTest() throws Exception {
        mockMvc.perform(get("/quote"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.author").isString())
                .andExpect(jsonPath("$.quote").isString());
    }

    @Test
    public void shouldReturnNotFound404ForInvalidEndpoint() throws Exception {
        mockMvc.perform(get("/quotes"))
                .andExpect(status().isNotFound());
    }

}
