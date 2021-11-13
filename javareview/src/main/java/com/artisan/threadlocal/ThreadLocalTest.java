package com.artisan.threadlocal;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/8/1 16:48
 * @mark: show me the code , change the world
 */
public class ThreadLocalTest {


    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        threadLocal.set("artisan Test");

        doSomething();

    }

    private static void doSomething() {
        System.out.println("threadLocal中的对象:" + threadLocal.get());

        new Thread(()->{
            System.out.println("开启子线程");
            System.out.println("子线程中获取threadLocal：" + threadLocal.get());
        }).start();

    }
}
    