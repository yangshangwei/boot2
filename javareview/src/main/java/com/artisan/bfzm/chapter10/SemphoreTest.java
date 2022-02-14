package com.artisan.bfzm.chapter10;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/14 23:59
 * @mark: show me the code , change the world
 */
public class SemphoreTest {

    // 1 创建Sempaphore实例
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 线程1 提交到线程池
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行结束 " + LocalTime.now());
            // 在每个线程内部调用信号量的release方法，这相当于让计数器值递增1
            semaphore.release();

        });

        // 线程2 提交到线程池
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " 执行结束 "  + LocalTime.now());
                // 在每个线程内部调用信号量的release方法，这相当于让计数器值递增1
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 1 等待子线程执行任务完成后返回
        semaphore.acquire(3);

        System.out.println(Thread.currentThread().getName() + "任务执行结束 " + LocalTime.now()) ;

        // 关闭线程池
        executorService.shutdown();

    }
}
    