package com.example;

public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
