package com.artisan.bfzm.chapter11;

import java.util.concurrent.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/20 23:33
 * @mark: show me the code , change the world
 */
public class PoolShutDownTest {

    public static void main(String[] args) {

        // 异步执行业务1
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10,
                TimeUnit.MINUTES, new LinkedBlockingDeque<>(100));

        threadPoolExecutor.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("业务1----模拟业务");

            threadPoolExecutor.shutdown();
        });

        // 异步执行业务2
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println("业务2");
            executorService.shutdown();
        });


        // 业务执行完成
        System.out.println("executor over");



    }
}
    