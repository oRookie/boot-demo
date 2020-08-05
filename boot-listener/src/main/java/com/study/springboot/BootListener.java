package com.study.springboot;

import com.study.springboot.listener.MyApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
public class BootListener {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootListener.class);
        application.addListeners(new MyApplicationListener());
        application.run(args);
    }
}
