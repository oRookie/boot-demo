package com.study.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("com.study.springboot.*")
public class TestAopController {
    public static void main(String[] args) {
        SpringApplication.run(TestAopController.class);
    }
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
