package com.example.chipimp.dao;


import com.example.chipimp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户的数据操作层接口
 */

@Mapper
@Repository
public interface UserMapper {

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
