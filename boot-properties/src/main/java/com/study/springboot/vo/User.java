package com.study.springboot.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lk
 */
@Component
@ConfigurationProperties("user")
@Data
public class User {
    private String name;
    private String username;
    private int sex;
    private int age;
}
