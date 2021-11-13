package com.artisan;

import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/27 9:28
 * @mark: show me the code , change the world
 */
public class Test {

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClient redisson = Redisson.create(config);
            RBlockingQueue<String> blockingQueue = redisson.getBlockingQueue("test_queue1");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(blockingQueue);
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        //阻塞队列有数据就返回，否则wait
                        System.out.println( blockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();

        for(int i=1;i<=100;i++) {
            // 向阻塞队列放入数据
            delayedQueue.offer("test"+i, 13, TimeUnit.SECONDS);
        }



//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379");
//        RedissonClient redisson = Redisson.create(config);
//        RBlockingQueue<String> blockingQueue = redisson.getBlockingQueue("dest_queue1");
//        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(blockingQueue);
//        delayedQueue.offer("demo", 10, TimeUnit.SECONDS);
//
//         TimeUnit.SECONDS.sleep(15);
    }

}
    