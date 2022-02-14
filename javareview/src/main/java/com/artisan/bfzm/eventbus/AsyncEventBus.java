package com.artisan.bfzm.eventbus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 10:59
 * @mark: show me the code , change the world
 */
public class AsyncEventBus extends EventBus {
    AsyncEventBus(String busName, EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        super(busName, exceptionHandler, executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor) {
        this("default-async", null, executor);
    }

    public AsyncEventBus(EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        this("default-async", exceptionHandler, executor);
    }
}
    