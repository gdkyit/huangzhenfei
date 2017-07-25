package com.database.demo.controller;

import com.database.demo.enrity.User;
import com.database.demo.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.database.demo.service.UserService;

import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/7/24 0024.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //
    //*查特定用户
    //
    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        List<Map<String, Object>> list = userService.getUser();
        ResponseMessage responseMessage = new ResponseMessage("200","",list);
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage("200", "", "删除成功");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.update(id, user);
        ResponseMessage responseMessage = new ResponseMessage("200", "", "修改成功");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        userService.insert(user);
        ResponseMessage responseMessage = new ResponseMessage("200", "","增加成功");
        return  new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }
}
