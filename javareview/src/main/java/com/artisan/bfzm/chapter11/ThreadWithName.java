package com.artisan.bfzm.chapter11;

import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/20 12:09
 * @mark: show me the code , change the world
 */
public class ThreadWithName {


    public static void main(String[] args) {
        Thread t1   = new Thread(() -> System.out.println("模块A开始处理业务"),"模块A");

        Thread t2   = new Thread(() -> {
            // 模拟业务
            System.out.println("模块B开始处理业务");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 模拟异常
            throw new NullPointerException();
        },"模块B线程");

        t1.start();
        t2.start();
    }
}
    