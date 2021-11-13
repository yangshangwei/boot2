package com.artisan.juc;

import java.util.concurrent.Semaphore;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/5 22:10
 * @mark: show me the code , change the world
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);


        semaphore.acquire();

        System.out.println("get Semaphore");

        semaphore.release();

    }
}
    