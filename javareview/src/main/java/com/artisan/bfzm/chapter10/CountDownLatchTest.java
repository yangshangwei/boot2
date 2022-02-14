package com.artisan.bfzm.chapter10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/19 10:46
 * @mark: show me the code , change the world
 */
public class CountDownLatchTest {

    // 创建一个CountDownLatch实例
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 模拟业务运行");

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " 业务运行Over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                // 子线程执行结束，减1
                countDownLatch.countDown();
            }


        });


        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 模拟业务运行");

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " 业务运行Over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                // 子线程执行结束，减1
                countDownLatch.countDown();
            }



        });

        // 等待子线程执行执行结束  返回
        countDownLatch.await();
        System.out.println( "子线程业务运行Over，主线程继续工作");

        executorService.shutdown();
    }
}
    