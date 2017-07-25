package com.database.demo.service;

import com.database.demo.enrity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 1
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        return jdbcTemplate.update("insert into zhenfei_user(username,password) VALUE (?,?)",new Object[]{user.getUsername(), user.getPassword()});
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM  zhenfei_user where id=?",id);
    }

    @Override
    public List<Map<String, Object>> getUser() {
        return  jdbcTemplate.queryForList("select * from zhenfei_user");
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("update zhenfei_user set username=?,password=? where id=?",new Object[]{user.getUsername(), user.getPassword(),id});
    }

}
