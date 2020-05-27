package com.scott.ds.service.impl;

import com.scott.ds.entity.User;
import com.scott.ds.mapper.UserDefaultMapper;
import com.scott.ds.service.UserDefaultService;
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
public class UserDefaultServiceImpl implements UserDefaultService {

    @Autowired
    private UserDefaultMapper userDefaultMapper;
    private static Log log = LogFactory.getLog(UserDefaultServiceImpl.class);

    public void testTransactional() {
        User user = new User();
        user.setUsername("Transactional");
        user.setPassword("Transactional");
        user.setSex(1);
        user.setAge(18);
        userDefaultMapper.save(user);
        User user1 = new User();
        user1.setId(2L);
        user1.setPassword("Transactional");
        // 返回插入的记录数 ，期望是1条 如果实际不是一条则抛出异常
        log.info("执行数据数量：" + userDefaultMapper.update(user1));
        throw new RuntimeException();
    }



    //    根据Id的查询用户信息
    public User selectUserById(Long id){return userDefaultMapper.selectById(id);}

    //    查询所有用户信息
    public List<User> selectUserList(){return userDefaultMapper.selectAll();}

    //    根据用户Id删除用户信息
    public int deleteUserById(Long id){return userDefaultMapper.deleteById(id);}

    //    添加用户信息
    public int addUser(User user){return userDefaultMapper.save(user);}

    //    修改用户信息
    public int updateUser(User user){return userDefaultMapper.update(user);}

    //    三张表一起查询
    public List<User> selectAllUsers(){return userDefaultMapper.selectAllUsers();}


    public int save1(User user){return userDefaultMapper.save1(user);}
    public int save2(User user){return userDefaultMapper.save2(user);}
    public int saveAll(User user){
        userDefaultMapper.save(user);
        userDefaultMapper.save1(user);
        userDefaultMapper.save2(user);
        return 1;
    }



}
