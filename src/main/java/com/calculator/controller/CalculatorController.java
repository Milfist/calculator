package com.calculator.controller;

import com.calculator.domain.CalculatorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class CalculatorController {

  @GetMapping("/sum")
  public ResponseEntity<CalculatorResponse> sum(@RequestParam(value = "num1") Integer num1, @RequestParam(value = "num2") Integer num2) {

    Integer sum = num1 + num2;

    return new ResponseEntity<>(new CalculatorResponse(String.valueOf(sum)), HttpStatus.OK);
  }





}
