package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public interface RestService {
    int delete(Integer id);
    int update(Integer id, User user);
    List<Map<String, Object>> get();

    int insert(User user);
    int[] insert(List<User> users);
    User getOne(Integer id);
    Map<String, Object> getMap(Integer id);
}
