package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MainService {
    public Map<String, Object> getApiInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "get method");
        return map;
    }

    public Map<String, Object> getApiInfo(String id, String cata) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "get method with param");
        map.put("pathvariable",id);
        map.put("requestparm",cata);
        return map;
    }

    public Map<String,Object> newApiInfo(Map<String,Object> body) {
        String username = "用户名是：" + (String)body.get("username");
        Map<String, Object> map = new HashMap<>();
        map.put("message", "post method");
        map.put("username",username);
        return map;
    }
}
