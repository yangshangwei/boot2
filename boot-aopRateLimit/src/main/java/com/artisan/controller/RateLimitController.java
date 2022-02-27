package com.artisan.controller;

import com.artisan.annos.ArtisanLimit;
import com.google.common.util.concurrent.RateLimiter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */

@Slf4j
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 限流策略 ： 1秒钟1个请求
     */
    private final RateLimiter limiter = RateLimiter.create(1);

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @SneakyThrows
    @GetMapping("/test")
    public String testLimiter() {
        //500毫秒内，没拿到令牌，就直接进入服务降级
        boolean tryAcquire = limiter.tryAcquire(500, TimeUnit.MILLISECONDS);

        if (!tryAcquire) {
            log.warn("BOOM 服务降级，时间{}", LocalDateTime.now().format(dtf));
            return "系统繁忙，请稍后再试！";
        }

        log.info("获取令牌成功，时间{}", LocalDateTime.now().format(dtf));

        return "业务处理成功";
    }


    @GetMapping("/test2")
    @ArtisanLimit(key = "testLimit2", permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS, message = "test2 当前排队人数较多，请稍后再试！")
    public String test2() {
        log.info("令牌桶test2获取令牌成功");
        return "test2 ok";
    }


    @GetMapping("/test3")
    @ArtisanLimit(key = "testLimit3", permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS, message = "test3 系统繁忙，请稍后再试！")
    public String test3() {
        log.info("令牌桶test3 获取令牌成功");
        return "test3 ok";
    }
}

    