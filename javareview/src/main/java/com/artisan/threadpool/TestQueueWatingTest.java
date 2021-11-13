package com.artisan.threadpool;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/6/28 12:12
 * @mark: show me the code , change the world
 */
public class TestQueueWatingTest {


    public static void main(String[] args) throws InterruptedException {

//        CountDownLatch countDownLatch = new CountDownLatch(1);

        AtomicInteger atomicInteger = new AtomicInteger();
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                12,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r,"Test-Thread-" +atomicInteger.getAndIncrement() );
                    }
                }
        );


        for (int i = 1; i <= 500000; i++) {
            threadPoolExecutor.execute(new Task());
            TimeUnit.SECONDS.sleep(2);
        }
        threadPoolExecutor.shutdown();
    }

}


class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +  "-----do bussiness");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



    