package com.artisan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */
@Service
public class BizManager {


    private final boolean APP = true;


    @Transactional(rollbackFor = Throwable.class)
    public void doBiz(String var1 , String var2) throws InterruptedException {
        if(APP) {
            // 模拟业务耗时
            TimeUnit.MILLISECONDS.sleep(1000);
        }else {

        }
    }
}
    