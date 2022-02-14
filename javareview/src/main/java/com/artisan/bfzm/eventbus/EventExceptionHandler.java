package com.artisan.bfzm.eventbus;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/1 23:03
 * @mark: show me the code , change the world
 */
public interface EventExceptionHandler {

    void handle(Throwable cause, EventContext context);
}
    