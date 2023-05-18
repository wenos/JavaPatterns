package com.example.test;


import org.springframework.stereotype.Component;

@Component("flashlight")
public class Flashlight implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Flashlight");
    }
}