package com.artisan.bfzm.chapter11;

import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/21 1:40
 * @mark: show me the code , change the world
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()){
                if (null != r && r instanceof FutureTask) {
                    ((FutureTask) r).cancel(true);
                }
            }
    }
}
    