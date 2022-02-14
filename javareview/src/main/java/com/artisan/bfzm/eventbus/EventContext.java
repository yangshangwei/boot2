package com.artisan.bfzm.eventbus;

import java.lang.reflect.Method;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/1 23:04
 * @mark: show me the code , change the world
 */
public interface  EventContext {


    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();


}
    