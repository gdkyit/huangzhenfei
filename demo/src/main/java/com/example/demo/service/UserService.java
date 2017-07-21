package com.example.demo.service;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public interface UserService {
    void create(String name, Integer age);
    void deleteByName(String name);
    Integer getAllUsers();
    void deleteAllUser();
}
