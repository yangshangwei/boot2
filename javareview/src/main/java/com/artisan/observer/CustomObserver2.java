package com.artisan.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/31 22:33
 * @mark: show me the code , change the world
 */
public class CustomObserver2 implements Observer {

    private String name ;


    public CustomObserver2(String name) {
        this.name = name;
    }



    @Override
    public void update(Observable o, Object arg) {

        Subject subject = (Subject)o;
        System.out.println(name + " 收到通知:" + subject.getMessage());
    }
}
    