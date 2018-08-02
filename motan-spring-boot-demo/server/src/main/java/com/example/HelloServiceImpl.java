package com.example;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hi "+name+"!";
    }
}
