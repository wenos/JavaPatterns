package com.example.test;

import org.springframework.stereotype.Component;

@Component("lamp")
public class Lamp implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Lamp");
    }
}
