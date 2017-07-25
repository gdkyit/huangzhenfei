package com.database.demo.dao;

import com.database.demo.enrity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
@Repository("UserDao")
public class UserDaoImpl implements BaseDao<User>{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE  *  FROM  zhenfei_user where id=?",id);
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("UPDATE id,user  FROM zhenfei_user where id=?",id);
    }

    @Override
    public List<Map<String, Object>> getDatas() {
        return jdbcTemplate.queryForList("SELECT * FROM zhenfei_user");
    }

    @Override
    public int insert(User user) {
        return jdbcTemplate.update
                ("INSERT INTO zhenfei_user(user, password) VALUE (?,?)",
                        new Object[]{user.getUsername(), user.getPassword()});
    }
}
