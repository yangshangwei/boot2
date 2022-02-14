package com.artisan.bfzm.eventbus;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 11:02
 * @mark: show me the code , change the world
 */
public class SimpleObject {

    /**
     * subscribe方法，比如使用@Subscribe标记，并且是void类型且有一个参数
     */
    @Subscribe(topic = "artisan-topic")
    public void test2(Integer x) {

    }

    @Subscribe(topic = "test-topic")
    public void test3(Integer x) {
    }
}
    