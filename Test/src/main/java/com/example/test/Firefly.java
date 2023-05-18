package com.example.test;

import com.example.test.Lighter;
import org.springframework.stereotype.Component;

@Component("firefly")
public class Firefly implements Lighter {
    @Override
    public void doLight() {
        System.out.println("Firefly");
    }
}