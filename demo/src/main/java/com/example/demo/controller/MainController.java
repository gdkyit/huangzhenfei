package com.example.demo.controller;


import com.example.demo.entity.ResponseMessage;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;

    /**
     * http get类型接口，通常用于获取资源列表
     * 接口访问样例：localhost:8080/api
     * @return
     */
    @GetMapping(value = "/api")
    public ResponseEntity<?> getApiInfo() {
        Map<String,Object> result = mainService.getApiInfo();
        ResponseMessage rm = new ResponseMessage("200","",result);
        return new ResponseEntity<>(rm, HttpStatus.OK) ;

    }

    /**
     * http get 类型接口，带有路径参数和url参数，通常用于获取特定对象信息，或者用于带条件过滤资源列表结果
     * 接口访问例子：localhost:8080/api/23?cata=book
     * @param id 路径变量参数
     * @param cata url变量参数
     * @return
     */
    @GetMapping(value = "/api/{id}")
    public ResponseEntity<?> getApiInfoWithParam(@PathVariable String id, @RequestParam String cata) {
        Map<String,Object> result = mainService.getApiInfo(id,cata);
        ResponseMessage rm = new ResponseMessage("200","",result);
        return new ResponseEntity<>(rm, HttpStatus.OK) ;

    }

    /**
     * http post类型接口，通常用于新增一个资源对象
     * 接口访问例子：localhost:8080/api ，使用post方式访问，body的形式为{"username":"自己写内容"}
     * 访问时要为header添加属性 content-type:application/json
     * @param body
     * @return
     */
    @PostMapping(value = "/api")
    public ResponseEntity<?> newApiInfo(@RequestBody Map<String,Object> body) {
        Map<String,Object> result = mainService.newApiInfo(body);
        ResponseMessage rm= new ResponseMessage("201","",result);
        return new ResponseEntity<>(rm, HttpStatus.CREATED) ;

    }

    /**
     * http put类型接口，通常用户更新一个资源
     * @param body
     * @return
     */
    @PutMapping(value = "/api/{id}")
    public ResponseEntity<?> updateApiInfo(@PathVariable String id, @RequestBody Map<String,Object> body) {
        Map<String,Object> result = mainService.newApiInfo(body);
        ResponseMessage rm = new ResponseMessage("202","",result);
        return new ResponseEntity<>(rm, HttpStatus.OK) ;
    }

    /**
     * http delete类型接口，通常用于删除一个资源
     * @param body
     * @return
     */
    @DeleteMapping(value = "/api/{id}")
    public ResponseEntity<?> ApiInfo(@PathVariable String id, @RequestBody Map<String,Object> body) {
        Map<String,Object> result = mainService.newApiInfo(body);
        ResponseMessage rm = new ResponseMessage("203","",result);
        return new ResponseEntity<>(rm, HttpStatus.CREATED) ;

    }
}
