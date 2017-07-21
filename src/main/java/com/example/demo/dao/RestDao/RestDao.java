package com.example.demo.dao.RestDao;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public interface RestDao {
    int delete(Integer id);
    int update(Integer id, User user);
    List<Map<String, Object>> get();
    int insert(User user);
    User getOne(Integer id);
    int[] batchInsert(List<User> user);
    Map<String, Object> getMap(Integer id);
}