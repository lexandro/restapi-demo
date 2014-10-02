package com.lexandro.restapi.service;


import org.springframework.stereotype.Service;

@Service
public class DefaultHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
