package com.artisan.delayQueue;

import java.util.concurrent.CountDownLatch;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/4 21:21
 * @mark: show me the code , change the world
 */
public class MTest {

    private static final int threadNum = 10;

    private static CountDownLatch cdl = new CountDownLatch(threadNum);

    static class DelayMessage implements Runnable {
        @Override
        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RedisDelayQueue appTest = new RedisDelayQueue();
            appTest.consumerDelayMessage();
        }
    }

    public static void main(String[] args) {
        RedisDelayQueue appTest = new RedisDelayQueue();
        appTest.productionDelayMessage();
        for (int i = 0; i < threadNum; i++) {
            new Thread(new DelayMessage()).start();
            cdl.countDown();
        }
    }
}
    