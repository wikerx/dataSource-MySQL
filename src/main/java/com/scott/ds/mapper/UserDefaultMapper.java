package com.scott.ds.mapper;


import com.scott.ds.annotation.DataSource;
import com.scott.ds.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: scott
 * @Date: 2018/8/13 19:47
 * @Description: UserMapper接口
 */
@DataSource//默认数据源
public interface UserDefaultMapper {

    /**
     * 新增用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @DataSource("slave1")  //默认数据源
    int update(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @DataSource("slave2")  //slave1
    User selectById(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll();

    /**
     * 三张表一起查询
     * */
    @Select("SELECT * FROM `master`.user UNION SELECT * FROM `slave1`.user UNION SELECT * FROM `slave2`.user")
    List<User> selectAllUsers();
    /**
     * 三张表新增用户
     * */
    @DataSource("slave1")
    int save1(User user);

    @DataSource("slave2")
    int save2(User user);
}
