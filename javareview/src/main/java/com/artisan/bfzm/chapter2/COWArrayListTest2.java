package com.artisan.bfzm.chapter2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/1 21:17
 * @mark: show me the code , change the world
 */
public class COWArrayListTest2 {

    private static volatile CopyOnWriteArrayList cow = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {


        cow.add("hello");
        cow.add("artisan");
        cow.add("learn");
        cow.add("ml");


        Thread thread = new Thread(() -> {
            System.out.println("异步线程开始操作COW~");
            // 异步线程修改  删除
            cow.set(0, "xxxx");
            cow.remove(1);
            cow.remove(2);


            Iterator iterator = cow.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println("异步线程结束操作COW~");

        });

        // 一定要在异步线程启动前获取到 迭代器
        Iterator iterator = cow.iterator();


        // 启动线程
        thread.start();


        // 等待子线程结束
        thread.join();

        // 遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
    