package com.artisan.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/6 13:11
 * @mark: show me the code , change the world
 */
public class CASTest {

    public static void main(String[] args) {

        // 设置初始值为100
        AtomicInteger atomicInteger = new AtomicInteger(100);

        // 使用atomicInteger的compareAndSet，如果为100，则更新为123
        boolean b = atomicInteger.compareAndSet(100, 123);
        System.out.println(b + "----" + atomicInteger.get());

        // 使用atomicInteger的compareAndSet，如果为100，则更新为456 (上一步已经更新成了123，所以不是100)
        b = atomicInteger.compareAndSet(100, 456);
        System.out.println(b + "----" + atomicInteger.get());

        // 当前值
        System.out.println(atomicInteger.get());
        // 先获取，再加1
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        // 先加1，再获取加一后的值
        System.out.println(atomicInteger.incrementAndGet());

    }
}
    