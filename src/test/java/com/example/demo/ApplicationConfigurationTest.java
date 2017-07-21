package com.example.demo;

import com.example.demo.DemoApplication;
import com.example.demo.service.UserService;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ApplicationConfigurationTest {

    @Autowired
    private UserService userSerive;

    @Before
    public void setUp(){
        userSerive.deleteAllUser();
    }

    @Test
    public void test() throws Exception{
        //插入5个用户
        userSerive.create("a",1);
        userSerive.create("b",2);
        userSerive.create("c",3);
        userSerive.create("d",4);
        userSerive.create("e",5);



        //删除两个用户
        userSerive.deleteByName("a");
        userSerive.deleteByName("e");

        //查询数据库
        Assert.assertEquals(3,userSerive.getAllUsers().intValue());

    }
}
