package com.database.demo.service;

import com.database.demo.enrity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public interface UserService{
    int insert(User user);

    int delete(Integer id);

    List<Map<String, Object>> getUser();

    int update(Integer id, User user);

}
