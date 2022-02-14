package com.artisan.bfzm.eventbus;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 11:16
 * @mark: show me the code , change the world
 */
public class SimpleSubscriber3 {

    @Subscribe
    public void method1(Object message) {
        if (message instanceof WildMessage){
            System.out.println(String.format("线程 %s , SimpleSubscriber3#method1 called --- %s ",Thread.currentThread().getName() ,((WildMessage)message).getData()));
        }
    }


}
    