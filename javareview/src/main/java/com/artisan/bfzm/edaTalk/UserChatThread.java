package com.artisan.bfzm.edaTalk;

import com.artisan.bfzm.edaPrac.async.AsyncEventDispatcher;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 16:24
 * @mark: show me the code , change the world
 */
public class UserChatThread extends Thread {

    private final User user;
    private final AsyncEventDispatcher dispatcher;

    public UserChatThread(User user, AsyncEventDispatcher dispatcher) {
        super(user.getName());
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            //User上线，发送Online Event
            dispatcher.dispatch(new UserOnlineEvent(user));
            for (int i = 0; i < 5; i++) {
                //发送User的聊天信息
                dispatcher.dispatch(new UserChatEvent(user, getName() + "-Hello-" + i));
                //短暂休眠1～10秒
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //User下线，发送Offline Event
            dispatcher.dispatch(new UserOfflineEvent(user));
        }
    }
}
    