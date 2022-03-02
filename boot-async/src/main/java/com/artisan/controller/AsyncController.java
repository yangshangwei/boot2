package com.artisan.controller;

import com.artisan.jobs.AsyncJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/1 0:44
 * @mark: show me the code , change the world
 */

@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {


    @Autowired
    private AsyncJob asyncJob;

    @RequestMapping("/job")
    public String task() throws InterruptedException {
        long beginTime = System.currentTimeMillis();

        // 执行异步任务
        asyncJob.job1();
        asyncJob.job2();
        asyncJob.job3();

        // 模拟业务耗时
        Thread.sleep(1000);


        long cost = System.currentTimeMillis() - beginTime;
        log.info("main cost {} ms", cost);

        return "Task Cost " + cost + " ms";
    }
}
    