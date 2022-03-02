package com.artisan.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 0:42
 * @mark: show me the code , change the world
 */

@Component
@Slf4j
public class AsyncJob {


    @Async("tp1")
    public void job1() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis();
        log.info("job1 cost {} ms", endTime - beginTime);
    }

    @Async("tp2")
    public void job2() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis();
        log.info("job2 cost {} ms", endTime - beginTime);
    }

    @Async()
    public void job3() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis();
        log.info("job3 cost {} ms", endTime - beginTime);
    }
}
    