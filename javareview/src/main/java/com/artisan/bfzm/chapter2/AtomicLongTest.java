package com.artisan.bfzm.chapter2;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/30 22:52
 * @mark: show me the code , change the world
 */
public class AtomicLongTest {

    //(10)创建Long型原子计数器
  //  private static AtomicLong atomicLong = new AtomicLong();

    private static LongAdder longAdder = new LongAdder();

    //(11)创建数据源
    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws InterruptedException {
        //（12）线程one统计数组arrayOne中0的个数
        Thread threadOne = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOne[i].intValue() == 0) {
                    longAdder.increment();
                }
            }

        });
        //（13）线程two统计数组arrayTwo中0的个数
        Thread threadTwo = new Thread(() -> {
            int size = arrayTwo.length;
            for (int i = 0; i < size; ++i) {
                if (arrayTwo[i].intValue() == 0) {
                    longAdder.increment();
                }
            }
        });
        //(14)启动子线程
        threadOne.start();
        threadTwo.start();
        //(15)等待线程执行完毕
        threadOne.join();
        threadTwo.join();
        System.out.println("count 0:" + longAdder.sum());
    }

}
    