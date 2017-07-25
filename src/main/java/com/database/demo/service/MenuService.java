package com.database.demo.service;

import com.database.demo.enrity.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public interface MenuService {
    int insert(Menu menu);

    int delete(Integer id);

    List<Map<String, Object>> getMenu();

    int update(Integer id, Menu menu);
}
