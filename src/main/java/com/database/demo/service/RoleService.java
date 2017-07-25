package com.database.demo.service;

import com.database.demo.enrity.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public interface RoleService {
    int insert(Role role);

    int delete(Integer id);

    List<Map<String, Object>> getRole();

    int update(Integer id, Role role);
}
