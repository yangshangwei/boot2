package com.artisan.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/11 16:56
 * @mark: show me the code , change the world
 */


@Service
@Slf4j
public class ArtisanService {

    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 500L, maxDelay = 3000L, multiplier = 2, random = true))
    public String test() {

        int i = 1 / 0;
        return "over";
    }


}
    