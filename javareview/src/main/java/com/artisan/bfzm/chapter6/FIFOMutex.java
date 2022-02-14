package com.artisan.bfzm.chapter6;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 9:42
 * @mark: show me the code , change the world
 */
public class FIFOMutex {

    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock(){

        boolean wasInterrupted = false ;
        // 当期线程
        Thread current = Thread.currentThread();
        waiters.add(current);

        // 1 只有队首的线程可以获取锁
        while(waiters.peek() != current || !locked.compareAndSet(false,true)){
                LockSupport.park(this);

                if (Thread.interrupted()) { // 2
                    wasInterrupted = true;
                }
        }

        waiters.remove();

        if (wasInterrupted){ // 3
            current.interrupt();
        }


    }

    public void unlock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }


}
    