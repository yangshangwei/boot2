package com.artisan.bfzm.eventbus;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 11:16
 * @mark: show me the code , change the world
 */
public class SimpleSubscriber2 {

    @Subscribe
    public void method1(String message) {
        System.out.println(String.format("线程 %s , SimpleSubscriber2#method1 called --- %s ",Thread.currentThread().getName() ,message));
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println(String.format("线程：%s:  Test Topic | SimpleSubscriber2#method2 called --- %s", Thread.currentThread().getName(), message));
    }
}
    