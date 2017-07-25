package com.database.demo.controller;

import com.database.demo.enrity.Role;
import com.database.demo.service.RoleService;
import com.database.demo.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<?> getUsers(){
        List<Map<String, Object>> list = roleService.getRole();
        ResponseMessage responseMessage = new ResponseMessage("200", "", list);
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/roles/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        roleService.delete(id);
        ResponseMessage responseMessage = new ResponseMessage("200", "","");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    @PutMapping("roles")
    public ResponseEntity<?> updateUser(@RequestBody Role role){
        roleService.insert(role);
        ResponseMessage responseMessage = new ResponseMessage("200", "","");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<?> insertUser(@RequestBody  Role role){
        roleService.insert(role);
        ResponseMessage responseMessage = new ResponseMessage("200","","增加成功");
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }
}
