package com.artisan.threadpool;

import java.util.concurrent.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/6/28 12:12
 * @mark: show me the code , change the world
 */
public class TestException2WatingTest {

    public static void main(String[] args) throws Exception {

        LinkedBlockingQueue workQueue = new LinkedBlockingQueue<>(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 12, 20, TimeUnit.SECONDS, workQueue);


        for (int i = 0; i < 100000; i++) {
            threadPoolExecutor.execute(new Job());
            TimeUnit.MILLISECONDS.sleep(10);
        }


    }

    static class Job implements Runnable {

        @Override
        public void run() {

            try {
//                int i = 1 / 0;
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (Exception e) {
                System.out.println("当前任务发生异常.....");
            }
            System.out.println("当前任务OK.....");

        }
    }
}


    