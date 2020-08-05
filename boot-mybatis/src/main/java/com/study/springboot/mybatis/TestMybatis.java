package com.study.springboot.mybatis;

import com.study.springboot.mybatis.entity.User;
import com.study.springboot.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
//@MapperScan("com.study.springboot.mybatis.dao")
public class TestMybatis {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(TestMybatis.class,args);
    }

    @GetMapping("users")
    public List<User> users(){
        MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
        System.out.println(userService.selectAll());
        System.out.println(sqlSession);
        return userService.selectAll();
    }

}
