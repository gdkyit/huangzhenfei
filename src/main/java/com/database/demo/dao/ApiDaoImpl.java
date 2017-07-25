package com.database.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class ApiDaoImpl implements ApiDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * 获取某个用户所有功能模块
    * */
    @Override
    public List<Map<String, Object>> getMenusByUserId(Integer id) {
        return jdbcTemplate.queryForList("select menu.menuname from yexugang_user_role user_role,yexugang_role_menu role_menu,yexugang_menu menu" +
                " where user_role.rid = role_menu.rid and role_menu.menuid = menu.id and user_role.uid = ? ", id);
    }

    /*
    * 获取该用户的明细信息，包括其所在的角色组和被授权的功能模块菜单
    * */
    @Override
    public List<Map<String, Object>> getUserInfo(Integer id) {
        return jdbcTemplate.queryForList("select role.rolename ,menu.menuname FROM yexugang_user_role user_role , yexugang_role role,yexugang_role_menu role_menu,yexugang_menu menu " +
                " where user_role.uid = ? and user_role.rid = role.id and role_menu.rid = user_role.rid and role_menu.menuid = menu.id", id);
    }


    /*
    * 修改角色菜单关系
    * */
    @Override
    public int updateRoleAndMenu(Integer roleId, Integer menuId) {
        return jdbcTemplate.update("insert yexugang_role_menu (rid,menuid) VALUE (?,?)", new Object[]{roleId, menuId});
    }

    /*
    * 修改角色用户关系
    * */
    @Override
    public int updateRoleAndUser(Integer roleId, Integer userId) {
        return jdbcTemplate.update("insert yexugang_user_role (uid,rid) VALUE (?,?)", new Object[]{userId, roleId});
    }
}
