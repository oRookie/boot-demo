package com.study.springboot.mybatis.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private int id;
    private String name;
    private int sex;
    private int courseId;
}
