package com.artisan.bfzm.chapter6;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 22:59
 * @mark: show me the code , change the world
 */
public class NonReentrantLockTest {

    static NonReentrantLock lock = new NonReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();
    static Queue<String> queue = new LinkedBlockingQueue<>();
    static int queueSize = 10;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                //如果队列满了，则等待
                while (queue.size() == queueSize) {
                    notEmpty.await();
                }
                //添加队列元素
                queue.add("element ");
                //唤醒消费线程
                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //释放锁
                lock.unlock();
            }

        });

        Thread consumer = new Thread(() -> {
            lock.lock();

            try {
                //队列为空，则等待
                while (queue.size()==0){
                    notFull.await();
                }
                //消费元素
                queue.poll();
                //唤醒生产线程
                notEmpty.signalAll();

            }catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        producer.start();
        consumer.start();
    }
}
    