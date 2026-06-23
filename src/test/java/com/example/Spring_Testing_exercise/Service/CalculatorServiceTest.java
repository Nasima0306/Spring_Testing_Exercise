package com.example.Spring_Testing_exercise.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    CalculatorService service=new CalculatorService();
    @Test
    public void testAdd(){
         int a=2;
         int b=3;
         int result= service.add(a,b);
         assertEquals(5,result);
    }
}
