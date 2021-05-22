package com.artisan.observer;

import java.util.Observable;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/31 22:36
 * @mark: show me the code , change the world
 */
public class Subject extends Observable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void publish(String message){

        this.message = message ;
        // 业务逻辑
        System.out.println("Subject mock to ChangeSomething ....");

        // 改变状态
        this.setChanged();

        // 通知所有观察者
        this.notifyObservers();
    }

}
    