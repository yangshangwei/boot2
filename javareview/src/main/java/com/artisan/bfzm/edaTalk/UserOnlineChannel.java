package com.artisan.bfzm.edaTalk;

import com.artisan.bfzm.edaPrac.Event;
import com.artisan.bfzm.edaPrac.async.AsyncChannel;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 16:10
 * @mark: show me the code , change the world
 */
public class UserOnlineChannel extends AsyncChannel {


    @Override
    protected void dealEvent(Event event) {
        UserOnlineEvent userOnlineEvent = (UserOnlineEvent) event;
        System.out.println("The User[" + userOnlineEvent.getUser().getName() + "] is online.");
    }
}
    