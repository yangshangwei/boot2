package com.artisan.threadlocal;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/8/1 16:48
 * @mark: show me the code , change the world
 */
public class InheritableThreadLocalTest {


    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        InheritableThreadLocalTest threadLocalTest = new InheritableThreadLocalTest();

        threadLocal.set("artisan InheritableThreadLocal");

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
    