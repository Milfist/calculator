package com.calculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SumServiceTest {

  @Autowired
  private SumService service;

  @Test
  void given_two_numbers_must_return_their_sum() {
    Integer num1 = 2;
    Integer num2 = 4;

    Integer expected = service.sum(num1, num2);

    assertEquals(6, expected);
  }

}
