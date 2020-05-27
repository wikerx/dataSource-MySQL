package com.scott.ds.service.impl;

import com.scott.ds.entity.User;
import com.scott.ds.mapper.UserMapper;
import com.scott.ds.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName :UserServiceImpl
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/10/9  16:38
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    static Log log = LogFactory.getLog(UserServiceImpl.class);

    public void testTransactional() {
        User user = new User();
        user.setUsername("Transactional");
        user.setPassword("Transactional");
        user.setSex(1);
        user.setAge(18);
        userMapper.save(user);
        User user1 = new User();
        user1.setId(2L);
        user1.setPassword("Transactional");
        // 返回插入的记录数 ，期望是1条 如果实际不是一条则抛出异常
        log.info("执行数据数量：" + userMapper.update(user1));
        throw new RuntimeException();
    }



    //    根据Id的查询用户信息
    public User selectUserById(Long id){return userMapper.selectById(id);}

    //    查询所有用户信息
    public List<User> selectUserList(){return userMapper.selectAll();}

    //    根据用户Id删除用户信息
    public int deleteUserById(Long id){return userMapper.deleteById(id);}

    //    添加用户信息
    public int addUser(User user){return userMapper.save(user);}

    //    修改用户信息
    public int updateUser(User user){return userMapper.update(user);}





}
