package com.example.test;

import org.springframework.stereotype.Component;

@Component("hello")
public class SayHello implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
