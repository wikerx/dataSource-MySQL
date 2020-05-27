package com.scott.ds.service;

import com.scott.ds.entity.User;

import java.util.List;

/**
 * @Auther: Mr.薛
 * @Date: 2018/8/17 08:55
 * @Description:
 */
public interface UserDefaultService {
//    数据测试
    public void testTransactional();

//    根据Id的查询用户信息
    public User selectUserById(Long id);

//    查询所有用户信息
    public List<User> selectUserList();

//    根据用户Id删除用户信息
    public int deleteUserById(Long id);

//    添加用户信息
    public int addUser(User user);

//    修改用户信息
    public int updateUser(User user);

//    三张表一起查询
    List<User> selectAllUsers();
    int save1(User user);
    int save2(User user);
    int saveAll(User user);
}
