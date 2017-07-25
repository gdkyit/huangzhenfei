package com.database.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017  七月  24  0024.
 */
public interface ApiDao {
    List<Map<String, Object>> getMenusByUserId(Integer id);

    List<Map<String, Object>> getUserInfo(Integer id);

    int updateRoleAndMenu(Integer roleId, Integer menuId);

    int updateRoleAndUser(Integer roleId, Integer userId);
}
