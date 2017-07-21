package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21 0021.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
    static Map<Long, User> users = Collection.synchronizedMap(new HashMap<Long, User());

    @RequestMapping(value="/")

}
