package com.database.demo.service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017  七月  21  0021.
 */
public interface ApiService {
    List<Map<String, Object>> getMenusByUserId(Integer id);

    List<Map<String, Object>> getUserInfo(Integer id);

    int updateRoleAndMenu(Integer roleId, Integer menuId);

    int updateRoleAndUser(Integer roleId, Integer userId);
}
