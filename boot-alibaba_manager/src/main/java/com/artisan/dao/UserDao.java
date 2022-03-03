package com.artisan.dao;

import com.artisan.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/3 19:05
 * @mark: show me the code , change the world
 */

@Repository
public class UserDao {

    public User selectUser(long idCard ,String name){
        return new User("artisan","12333");
    }
}
    