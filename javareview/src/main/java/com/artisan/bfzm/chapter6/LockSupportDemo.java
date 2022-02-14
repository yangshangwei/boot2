package com.artisan.bfzm.chapter6;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 8:53
 * @mark: show me the code , change the world
 */
public class LockSupportDemo {


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(()->{
            System.out.println("child thread begin to park");
            // 调用park方法，挂起自己，只有被中断才推出循环

            while(!Thread.currentThread().isInterrupted()){
                LockSupport.park();
            }

            System.out.println("child thread unpark");

        });
        // 启动子线程
        thread.start();

        // 主线程休眠1s
        TimeUnit.SECONDS.sleep(1);

        // 中断子线程
        //thread.interrupt();

    }
}
    