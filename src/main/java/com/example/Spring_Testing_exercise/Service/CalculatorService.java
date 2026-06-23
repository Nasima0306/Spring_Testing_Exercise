package com.example.Spring_Testing_exercise.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a,int b){
        return a+b;
    }
}
