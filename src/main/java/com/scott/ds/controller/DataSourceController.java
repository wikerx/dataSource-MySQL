package com.scott.ds.controller;

import com.alibaba.fastjson.JSON;
import com.scott.ds.entity.User;
import com.scott.ds.service.UserDefaultService;
import com.scott.ds.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @ClassName :DataSourceController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/10/9  16:47
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class DataSourceController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDefaultService userDefaultService;

    private static Log log = LogFactory.getLog(DataSourceController.class);

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object Test(){
        String result = "";
//        添加用户
        User u = new User();
        u.setAge((int)(1+Math.random()*(100-1+1)));
        u.setPassword("123456");
        u.setSex(1);
        u.setUsername("测试用户" + (int)(1+Math.random()*(100-1+1)));
        int m = userService.addUser(u);
        log.info("添加用户状态：" + m );
        List<User> list = userService.selectUserList();
        log.info("查询所有用户信息：" + JSON.toJSON(list));

//        修改用户
        u.setUsername("测试用户" + (int)(1+Math.random()*(100-1+1)));
        m = userService.updateUser(u);
        log.info("修改用户状态：" + m );
        list = userService.selectUserList();
        log.info("查询所有用户信息：" + JSON.toJSON(list));

//        删除用户信息
//        m = userService.deleteUserById(2L);
//        log.info("删除用户状态：" + m );
//        log.info("查询所有用户信息：" + JSON.toJSON(list));
        return JSON.toJSON(list);
    }

    @RequestMapping(value = "testDefault", method = RequestMethod.GET)
    public Object TestDefault(){
        String result = "";
//        添加用户
        User u = new User();
        u.setAge((int)(1+Math.random()*(100-1+1)));
        u.setPassword("123456");
        u.setSex(1);
        u.setUsername("测试用户" + (int)(1+Math.random()*(100-1+1)));
        int m = userDefaultService.addUser(u);
        log.info("添加用户状态（master）：" + m );
        List<User> list = userDefaultService.selectUserList();
        log.info("查询所有用户信息（master）：" + JSON.toJSON(list));

//        修改用户
        u.setUsername("测试用户" + (int)(1+Math.random()*(100-1+1)));
        m = userDefaultService.updateUser(u);
        log.info("修改用户状态（save1）：" + m );
        list = userDefaultService.selectUserList();
        log.info("查询所有用户信息（master）：" + JSON.toJSON(list));

        log.info("查询用户信息（save2）：" + JSON.toJSONString(userDefaultService.selectUserById(3L)));
//        删除用户信息
//        m = userDefaultService.deleteUserById(2L);
//        log.info("删除用户状态：" + m );
//        log.info("查询所有用户信息：" + JSON.toJSON(list));
        return JSON.toJSON(list);
    }


//    同时向3个数据库中插入同一条数据（自增ID可能不一致）
    @RequestMapping(value = "addAll", method = RequestMethod.GET)
    public Object addAll(){
        User u = new User();
        u.setAge((int)(1+Math.random()*(100-1+1)));
        u.setPassword("123456");
        u.setSex(1);
        u.setUsername("测试用户" + (int)(1+Math.random()*(100-1+1)));
//        先使用master，在迅速切换至save1，在切换至save2
        int m = userDefaultService.saveAll(u);
        return userDefaultService.selectAllUsers();
    }

}
