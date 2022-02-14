package com.artisan.bfzm.chapter11;

import java.util.concurrent.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/21 0:11
 * @mark: show me the code , change the world
 */
public class FutureTest {


    //  1 线程池单个线程，队列大小为1  - 初始化线程池
    private final static ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(1),
            new MyRejectedExecutionHandler());


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 2 添加你任务1
        Future futureOne = tpe.submit(() -> {
            System.out.println("开始处理业务1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("业务1执行结束");
            return "Result1";
        });

        // 3 添加你任务2
        Future futureTwo = tpe.submit(() -> {
            System.out.println("开始处理业务2");
            System.out.println("业务2执行结束");
            return "Result2";
        });

        // 4  添加任务3
        Future futureThree = null;
        try {
            futureThree = tpe.submit(() -> System.out.println("开始处理业务3"));
        } catch (Exception e) {
            System.out.print(e.getLocalizedMessage());
        }

        // 5 等待任务1执行完毕
        System.out.println("任务1返回结果： " + futureOne.get());
        // 6 等待任务2执行完毕
        System.out.println("任务2返回结果：  " + futureTwo.get());
        // 7 等待任务3执行完毕
        try{
            System.out.println("任务3返回结果：  " + futureThree==null?null:futureThree.get());
        }catch (Exception e){
            System.out.print("异常信息：" + e.getLocalizedMessage());
        }

        //关闭线程池,阻塞知道所有任务执行完毕
        tpe.shutdown();

    }
}
    