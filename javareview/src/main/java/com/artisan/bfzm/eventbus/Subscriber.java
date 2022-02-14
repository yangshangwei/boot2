package com.artisan.bfzm.eventbus;

import java.lang.reflect.Method;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/1 23:33
 * @mark: show me the code , change the world
 */
public class Subscriber {
    private final Object subscribeObject;

    private final Method subscribeMethod;

    private boolean disable = false;

    public Subscriber(Object subscribeObject, Method subscribeMethod) {
        this.subscribeObject = subscribeObject;
        this.subscribeMethod = subscribeMethod;
    }

    public Object getSubscribeObject() {
        return subscribeObject;
    }

    public Method getSubscribeMethod() {
        return subscribeMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
    