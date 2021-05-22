package com.artisan.observer;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/31 22:41
 * @mark: show me the code , change the world
 */
public class Test {

    public static void main(String[] args) {
        // 创建一个观察目标
        Subject subject  = new Subject();

        // 添加观察者
        subject.addObserver(new CustomObserver("观察者1"));
        subject.addObserver(new CustomObserver2("观察者2"));

        //  发布消息
        subject.publish("起床尿尿....");
    }
}
    