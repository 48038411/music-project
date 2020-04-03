package com.soft1851.music.mapper;

import com.soft1851.music.entity.User;

public interface UserMapper {

    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    User findByUserName(String name);

    /**
     * 根据user的id查询音乐
     * @param id
     * @return
     */
    User getMusicById(int id);
}
