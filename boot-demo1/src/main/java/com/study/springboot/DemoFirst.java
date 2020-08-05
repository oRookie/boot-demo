package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoFirst {
    public static void main(String[] args) {
        SpringApplication.run(DemoFirst.class,args);
    }

    @GetMapping("hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
