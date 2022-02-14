package com.artisan.bfzm.eventbus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 11:06
 * @mark: show me the code , change the world
 */
public class Test {

    public static void main(String[] args) {

        Bus bus = new EventBus("TestBus");

        // 注册
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        // 发布消息
        bus.post("Hello");
        bus.post("Hello", "test");

        bus.register(new SimpleSubscriber3());

        bus.post(new WildMessage("SourceMessage"));


        System.out.println("\n\n\n\n");

        System.out.println("-------异步-----");

        Bus asyncEventBus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        asyncEventBus.register(new SimpleSubscriber1());
        asyncEventBus.register(new SimpleSubscriber2());

        asyncEventBus.post("Hello");
        asyncEventBus.post("Hello", "test");
    }


}
    