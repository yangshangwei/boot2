package com.artisan.java8;

import java.util.concurrent.*;

/***************************************
 * @author:Alex Wang
 * @Date:2016/11/7 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class FutureInAction2 {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
                return "I am finished.";
            } catch (InterruptedException e) {
                return "I am Error.";
            }
        });

        //...
        //...
        //...
        //...
        //String value = future.get(10, TimeUnit.MICROSECONDS);
        while (!future.isDone()) {
            Thread.sleep(10);
        }
        System.out.println(future.get());
        executorService.shutdown();
    }
}