package com.example.test;

import org.springframework.stereotype.Component;

@Component("hi")
public class SayHi implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("Hi");
    }
}
