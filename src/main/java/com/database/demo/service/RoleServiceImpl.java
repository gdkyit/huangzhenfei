package com.database.demo.service;

import com.database.demo.dao.BaseDao;
import com.database.demo.enrity.Role;
import com.database.demo.enrity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class RoleServiceImpl implements RoleService {
    @Autowired
    private BaseDao roleDao;


    @Override
    public int insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public int delete(Integer id) {
        return roleDao.delete(id);
    }

    @Override
    public List<Map<String, Object>> getRole() {
        return roleDao.getDatas();
    }

    @Override
    public int update(Integer id, Role role) {
        return roleDao.update(id, role);
    }
}
