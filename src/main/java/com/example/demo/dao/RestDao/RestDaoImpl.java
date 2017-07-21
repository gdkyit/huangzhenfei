package com.example.demo.dao.RestDao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21 0021.
 */

@Repository
public class RestDaoImpl implements RestDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("UPDATE zhenfeitodo set title?, content=?,yxbz=? where id=?", user.getTitle(), user.getContent(),user.getYxbz(),id);
    }

    @Override
    public List<Map<String, Object>> get() {
        return jdbcTemplate.queryForList("SELECT * FROM zhenfeitodo");
    }

    @Override
    public int insert(User user) {
        return jdbcTemplate.update("insert into zhenfeitodo (title,content) VALUE (?,?)", new Object[]{user.getTitle(), user.getContent()});
    }

    @Override
    public User getOne(Integer id) {
        return jdbcTemplate.queryForObject("select * from xugang where id=?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(id);
                user.setId(resultSet.getInt("id"));
                user.setContent(resultSet.getString("content"));
                user.setTitle(resultSet.getString("title"));
                user.setTime(resultSet.getDate("time"));
                user.setYxbz(resultSet.getByte("yxbz"));
                return user;
            }
        }, id);
    }

    @Override
    public int[] batchInsert(List<User> user) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Integer id) {
        return jdbcTemplate.queryForMap("select * from xugang where id=?", id);
    }
}
