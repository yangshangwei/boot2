package com.artisan.java8.testFuture;

import java.util.concurrent.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/4/5 9:47
 * @mark: show me the code , change the world
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return "I'm OK ";
            } catch (InterruptedException e) {
                return "I'm Error ";
            }
        });



        while(!future.isDone()){
            Thread.sleep(10);
        }

        // 超时时间的阻塞
        // future.get(10,TimeUnit.SECONDS);
        // 调用get 阻塞
        System.out.println(future.get());

        executorService.shutdown();
    }
}
    