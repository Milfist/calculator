package com.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class SumService {

  public Integer sum (Integer num1, Integer num2) {
    return num1 + num2;
  }

}
