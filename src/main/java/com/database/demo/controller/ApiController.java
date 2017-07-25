package com.database.demo.controller;


import com.database.demo.service.ApiService;
import com.database.demo.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017  七月  21  0021.
 */
@Controller
public class ApiController {

    @Autowired
    private ApiService apiService;

    /*
    * 获取该user被允许的所有功能模块
    * */
    @GetMapping("/api/users/{userid}/menu")
    public ResponseEntity<?> getUserMenus(@PathVariable("userid") Integer id) {
        List<Map<String, Object>> maps = apiService.getMenusByUserId(id);
        ResponseMessage responseMessage = new ResponseMessage("200", "", maps);
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    /*
    *获取该用户的明细信息，包括其所在的角色组和被授权的功能模块菜单
    * */
    @GetMapping("/api/users/{userid}")
    public ResponseEntity<?> getUserInfo(@PathVariable Integer userid) {
        ResponseMessage responseMessage = new ResponseMessage("200", "", apiService.getUserInfo(userid));
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    /*
    * 可以更新role-menu的对应关系
    * */
    @PostMapping("/api/relation/rolemenu")
    public ResponseEntity<?> updateRelationRoleAndMenu(Integer roleId, Integer menuId) {
        apiService.updateRoleAndMenu(roleId, menuId);
        ResponseMessage responseMessage = new ResponseMessage("200", "", "添加成功");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    /*
    * 可以更新role-user的对应关系
    * */
    @PostMapping("/api/relation/roleuserk")
    public ResponseEntity<?> updateRelationRoleAndUser(Integer userId, Integer roleId) {
        apiService.updateRoleAndUser(roleId, userId);
        ResponseMessage responseMessage = new ResponseMessage("200", "", "添加成功");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }
}
