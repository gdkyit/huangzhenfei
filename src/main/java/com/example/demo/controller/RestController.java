package com.example.demo.controller;

import com.example.demo.entity.ResponseMessage;
import com.example.demo.entity.User;
import com.example.demo.service.RestService;
import com.example.demo.service.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21 0021.
 */

@Controller
public class RestController {
    @Autowired
    private RestService restService;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) throws Exception {
        //User user = restService.getOne(id);
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from zhenfeitodo where id=?", id);
        ResponseMessage rm = new ResponseMessage("200", "", restService.getMap(id));
        return new ResponseEntity<Object>(rm, HttpStatus.OK);
    }


    @PostMapping("/user")
    public ResponseEntity<?> postResult(@RequestBody User user) throws Exception {
        restService.insert(user);
        ResponseMessage rm = new ResponseMessage("200", "", "增加成功");
        return new ResponseEntity<Object>(rm, HttpStatus.OK);
    }


    @PostMapping("/batch/user")
    public ResponseEntity<?> postBatchResult(@RequestBody List<User> users) throws Exception {
        restService.insert(users);
        ResponseMessage rm = new ResponseMessage("200", "", "增加成功");
        return new ResponseEntity<Object>(rm, HttpStatus.OK);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<?> putResult(@PathVariable Integer id, @RequestBody User user) throws Exception {
        restService.update(id, user);
        ResponseMessage rm = new ResponseMessage("200", "", "修改成功");
        return new ResponseEntity<Object>(rm, HttpStatus.OK);
    }



    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteResult(@PathVariable Integer id) throws Exception {
        restService.delete(id);
        ResponseMessage rm = new ResponseMessage("200", "", "删除成功");
        return new ResponseEntity<Object>(rm, HttpStatus.OK);
    }
}
