package com.artisan.tuning02;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/4/24 9:10
 * @mark: show me the code , change the world
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        
        Thread.sleep(60_000);
        
        while (true){
            loadData();
        }
        
    }

    private static void loadData() throws InterruptedException {

        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;

        Thread.sleep(1000);
    }
}
    