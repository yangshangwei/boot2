package com.artisan.gqueu;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/8/15 22:09
 * @mark: show me the code , change the world
 */
public class GuardedQueue {

    private final Queue<Integer> sourceList;

    public GuardedQueue() {
        this.sourceList = new LinkedBlockingQueue<>();
    }

    public synchronized Integer get() {
        while (sourceList.isEmpty()) {
            try {
                wait();    // <--- 如果队列为null，等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sourceList.size());
        return sourceList.peek();
    }

    public synchronized void put(Integer e) {
        sourceList.add(e);
        notifyAll();  //<--- 通知，继续执行

        }

}
    