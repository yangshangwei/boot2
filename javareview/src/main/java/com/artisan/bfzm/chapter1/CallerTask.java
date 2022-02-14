package com.artisan.bfzm.chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/18 19:59
 * @mark: show me the code , change the world
 */
public class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        return "artisan OK";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> callerTaskFutureTask = new FutureTask(new CallerTask());

        new Thread(callerTaskFutureTask).start();

        // 等待结果
        String result = callerTaskFutureTask.get();

        System.out.println(result);

    }
}
    