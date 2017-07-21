package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into student(NAME,AGE) VALUE (?,?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from student WHERE NAME = ?", name);
    }

    @Override
    public Integer getAllUsers(){
        return  jdbcTemplate.queryForObject("select count(1) from student", Integer.class);
    }

    @Override
    public void deleteAllUser() {
        jdbcTemplate.update("delete from student");
    }
}
