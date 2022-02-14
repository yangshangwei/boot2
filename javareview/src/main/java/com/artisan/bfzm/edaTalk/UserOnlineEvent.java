package com.artisan.bfzm.edaTalk;

import com.artisan.bfzm.edaPrac.Event;
import com.artisan.bfzm.edaPrac.Message;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 16:01
 * @mark: show me the code , change the world
 */
public class UserOnlineEvent extends Event {

    private final User user ;

    public UserOnlineEvent(User user){
        this.user = user ;
    }

    public User getUser() {
        return user;
    }
}
    