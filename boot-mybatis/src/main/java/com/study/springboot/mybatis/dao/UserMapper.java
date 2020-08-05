package com.study.springboot.mybatis.dao;

import com.study.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from student")
    List<User> selectAll();
}
