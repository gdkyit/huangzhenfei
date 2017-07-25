package com.database.demo.service;

import com.database.demo.dao.BaseDao;
import com.database.demo.enrity.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class MenuServiceImpl implements MenuService{
    @Autowired
    private BaseDao menuDao;

    @Override
    public int insert(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public int delete(Integer id) {
        return menuDao.delete(id);
    }

    @Override
    public List<Map<String, Object>> getMenu() {
        return menuDao.getDatas();
    }

    @Override
    public int update(Integer id, Menu menu) {
        return menuDao.update(id,menu);
    }
}
