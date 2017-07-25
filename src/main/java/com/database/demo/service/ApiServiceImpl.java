package com.database.demo.service;


import com.database.demo.dao.ApiDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lenovo on 2017  七月  21  0021.
 */
@Service
public class ApiServiceImpl implements ApiService {
    /*
    * 日志打印
    * */
    private Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);
    @Autowired
    private ApiDao apiDao;

    /*
    * 获取某个用户所有功能模块
    * */
    @Override
    public List<Map<String, Object>> getMenusByUserId(Integer id) {
        List<Map<String, Object>> map = apiDao.getMenusByUserId(id);
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> resultmap = new HashMap<>();
        Set<Object> set = new HashSet<>();
        for (int i = 0; i < map.size(); i++) {
            set.add(map.get(i).get("menuname"));
        }
        resultmap.put("menus", set);
        result.add(resultmap);
        return result;
    }

    /*
    * 获取该用户的明细信息，包括其所在的角色组和被授权的功能模块菜单
    * */
    @Override
    public List<Map<String, Object>> getUserInfo(Integer id) {
        List<Map<String, Object>> map = apiDao.getUserInfo(id);
        /*logger.info(map.toString());
        Map<String, Object> result = new HashMap<>();
        result.put("角色组", map.get(0).get("rolename"));
        List<Object> menus = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            menus.add(map.get(i).get("menuname"));
        }
        result.put("功能菜单", menus);*/
        if (map.size() == 0) return new ArrayList<>();
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("users", map.get(0).get("rolename"));
        List<Object> menus = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            if (resultMap.get("users").equals(map.get(i).get("rolename"))) {
                menus.add(map.get(i).get("menuname"));
            } else {
                resultMap.put("menus", menus);
                result.add(resultMap);//第一行
                //初始化第2，3，。。。行
                menus = new ArrayList<>();
                menus.add(map.get(i).get("menuname"));
                resultMap = new HashMap<>();
                resultMap.put("users", map.get(i).get("rolename"));
            }
        }
        resultMap.put("menus", menus);
        result.add(resultMap);//第一行
        return result;
    }


    /*
    * 修改角色菜单关系
    * */
    @Override
    public int updateRoleAndMenu(Integer roleId, Integer menuId) {
        return apiDao.updateRoleAndMenu(roleId, menuId);
    }

    /*
    * 修改角色用户关系
    * */
    @Override
    public int updateRoleAndUser(Integer roleId, Integer userId) {
        return apiDao.updateRoleAndUser(roleId, userId);
    }
}
