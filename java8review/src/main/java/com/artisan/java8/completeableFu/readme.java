package com.artisan.java8.completeableFu;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * https://juejin.cn/post/6844903784812904456
 */
public class readme {

    private static Random random = new Random();
    private static long time = System.currentTimeMillis();

    public static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to compute, passed:" + System.currentTimeMillis());
        return random.nextInt(1000);
    }

    public static int throwException() {
        System.out.println("准备抛出异常");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("抛了");
        throw new RuntimeException("主动抛出异常");
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // 从打印结果可知，whenComplete使用原始的执行的任务的线程，所以可以看成是同步执行的，并且新的CompletableFuture对象的结果和原始的一致

       long time = System.currentTimeMillis();

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> getMoreData());
//
//        cost(time);
//
//        time = System.currentTimeMillis();
//        long finalTime = time;
//        CompletableFuture<Integer> future2 = future.whenComplete((result, excetion) -> {
//            System.out.println("执行到whenComplete了，result:" + result);
//            System.out.println("执行到whenComplete了，exception:" + (excetion == null ? "无异常" : excetion.getClass()));
//
//            cost(finalTime);
//        });
//
//        System.out.println("执行到最后一段代码了，future result：" + future.get()  );
//        cost(finalTime);
//        System.out.println("执行到最后一段代码了，future2 result：" + future2.get());
//        cost(finalTime);



        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> getMoreData());

        future.whenCompleteAsync((result, exception) -> {
            System.out.println("计算已执行完毕，result:" + result);
        });

        cost(time);
        System.out.println("执行到最后一段代码了，result：" + future.get());
        cost(time);

    }

    public static long cost(long startTime){
       long cost =  System.currentTimeMillis() - startTime ;
        System.out.println("cost: " + cost)  ;
        return  cost ;
    }
}