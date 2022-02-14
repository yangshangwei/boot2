package com.artisan.bfzm.chapter10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/18 15:23
 * @mark: show me the code , change the world
 */
public class CycleBarrierTest2 {

    // 创建一个CycleBarrier实例，添加一个所有子线程全部到达屏障后的执行的任务
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println(Thread.currentThread().getName() + " 阶段任务全部线程执行结束....开启下一轮"));


    public static void main(String[] args) {

        // 创建一个线程数量固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 将线程A 提交到线程池
        executorService.submit(() -> {


            try {
                System.out.println(Thread.currentThread().getName() + " execute step1");

                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " execute step2");

                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " execute step3");


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }


        });

        // 将线程B 提交到线程池
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " execute step1");

                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " execute step2");

                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " execute step3");


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }


        });


        // 关闭线程池
        executorService.shutdown();

    }

}
    