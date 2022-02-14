package com.artisan.bfzm.edaTalk;

import com.artisan.bfzm.edaPrac.async.AsyncEventDispatcher;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 16:15
 * @mark: show me the code , change the world
 */
public class UserChatApplication {


    public static void main(String[] args) {
        // 定义异步的Router
        final AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        //为Router注册Channel和Event之间的关系
        dispatcher.registerChannel(UserOnlineEvent.class, new UserOnlineChannel());
        dispatcher.registerChannel(UserOfflineEvent.class, new UserOfflineChannel());
        dispatcher.registerChannel(UserChatEvent.class, new UserChatEventChannel());


        //启动三个登录聊天室的User
        new UserChatThread(new User("Tom"), dispatcher).start();
        new UserChatThread(new User("Jack"), dispatcher).start();
        new UserChatThread(new User("Dave"), dispatcher).start();

    }

}
    