package com.study.springboot.mybatis.service;

import com.study.springboot.mybatis.dao.UserMapper;
import com.study.springboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}
