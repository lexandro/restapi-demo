package com.lexandro.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.lexandro.restapi"})
@EnableAutoConfiguration
public class DemoApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

}
