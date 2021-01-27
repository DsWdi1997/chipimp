package com.example.chipimp.service;


import com.example.chipimp.pojo.User;

import java.util.List;

/**
    *用户的服务层接口
 */

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectUser();

    /**
     * 根据id查询用户
     * @param user_id
     * @return
     */
    User selectUserById(int user_id);

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改一个用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     * @param user_id
     * @return
     */
    int deleteUser(int user_id);


}
