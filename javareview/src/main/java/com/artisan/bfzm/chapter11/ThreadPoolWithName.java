package com.artisan.bfzm.chapter11;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/20 12:09
 * @mark: show me the code , change the world
 */
public class ThreadPoolWithName {


    public static void main(String[] args) {

        ThreadPoolExecutor tpe1 = new ThreadPoolExecutor(5,5,10,TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(),new NamedThreadFactory("业务A-",false));

        ThreadPoolExecutor tpe2 = new ThreadPoolExecutor(5,5,10,TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(),new NamedThreadFactory("业务B-",false));


        tpe1.execute(()->System.out.println("模块A 执行业务"));
        tpe2.execute(()->{
            System.out.println("模块B 执行业务");
            //  模拟业务异常
            throw  new NullPointerException();
        });

        tpe1.shutdown();
        tpe2.shutdown();
    }
}
    