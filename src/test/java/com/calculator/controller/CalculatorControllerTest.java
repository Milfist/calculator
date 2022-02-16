package com.calculator.controller;

import com.calculator.CalculatorApplication;
import com.calculator.domain.CalculatorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.text.StringCharacterIterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = CalculatorApplication.class)
class CalculatorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
  }

  @Test
  void when_call_sum_endpoint_then_return_200() throws Exception {

    var endpoint = String.format("/api/v1/sum?num1=%d&num2=%d", 3, 5);
        // Expected
        HttpStatus expectedStatusCode = HttpStatus.OK;
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResponse = objectMapper.writeValueAsString(new CalculatorResponse("8"));

        assertResponse(endpoint, expectedStatusCode, expectedResponse);

  }

  private void assertResponse(String endpoint, HttpStatus expectedStatusCode, String expectedResponse) throws Exception {
    ResultMatcher response = expectedResponse.isEmpty() ?
        content().string("") : content().json(expectedResponse);

    mockMvc.perform(get(endpoint))
        .andExpect(status().is(expectedStatusCode.value()))
        .andExpect(response);
  }
}
