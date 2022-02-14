package com.artisan.bfzm.chapter11;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/21 20:28
 * @mark: show me the code , change the world
 */
public class TimerTest {


    public static void main(String[] args) throws InterruptedException {


        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        scheduledThreadPoolExecutor.schedule(()->{
            System.out.println("Task1 Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 模拟发生异常
            throw new RuntimeException();
        },1, TimeUnit.SECONDS);


        scheduledThreadPoolExecutor.schedule(()->{
            System.out.println("Task2 Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 关闭线程池
            scheduledThreadPoolExecutor.shutdown();

        },1, TimeUnit.SECONDS);

    }

}
    