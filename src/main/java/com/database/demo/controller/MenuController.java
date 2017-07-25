package com.database.demo.controller;

import com.database.demo.enrity.Menu;
import com.database.demo.service.MenuService;
import com.database.demo.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.menu;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public ResponseEntity<?> getMenus(){
        List<Map<String, Object>> list = menuService.getMenu();
        ResponseMessage responseMessage = new ResponseMessage("200","",list);
        return new ResponseEntity<Object>(responseMessage, HttpStatus.MULTI_STATUS.OK);
    }

    @DeleteMapping("/menus/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody Menu menu){
        menuService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage("200","","删除成功");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.MULTI_STATUS.OK);
    }

    @PostMapping("/menus")
    public ResponseEntity<?> insertUser(@RequestBody Menu menu){
            menuService.insert(menu);
            ResponseMessage responseMessage = new ResponseMessage("200","","增加成功");
            return new ResponseEntity<Object>(responseMessage, HttpStatus.MULTI_STATUS.OK);
       }

}

