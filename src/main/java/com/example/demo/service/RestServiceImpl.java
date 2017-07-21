package com.example.demo.service;

import com.example.demo.dao.RestDao.RestDao;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
@Service
public class RestServiceImpl implements RestService{
   @Resource
   private RestDao restDao;


    @Override
    public int delete(Integer id) {
        return restDao.delete(id);
    }

    @Override
    public int update(Integer id, User user) {
        user.setTime(new Date());
        return restDao.update(id,user);
    }

    @Override
    public List<Map<String, Object>> get() {
        return restDao.get();
    }

    @Override
    public int insert(User user) {
        user.setTime(new Date());
        return restDao.insert(user);
    }

    @Override
    public int[] insert(List<User> users) {
        return  restDao.batchInsert(users);
    }

    @Override
    public User getOne(Integer id) {
        return restDao.getOne(id);
    }

    @Override
    public Map<String, Object> getMap(Integer id) {
        return restDao.getMap(id);
    }
}
