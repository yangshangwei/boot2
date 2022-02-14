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
public class UserOfflineChannel extends AsyncChannel {


    @Override
    protected void dealEvent(Event event) {
        UserOfflineEvent userOfflineEvent = (UserOfflineEvent) event;
        System.out.println("The User[" + userOfflineEvent.getUser().getName() + "] is offline.");
    }
}
    