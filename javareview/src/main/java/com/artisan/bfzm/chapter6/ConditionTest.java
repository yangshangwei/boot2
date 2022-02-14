package com.artisan.bfzm.chapter6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 20:56
 * @mark: show me the code , change the world
 */
public class ConditionTest {


    public static void main(String[] args) {

        // 1
        ReentrantLock lock = new ReentrantLock();
        // 2
        Condition condition = lock.newCondition();

        // 3
        lock.lock();
        try {
            System.out.println("begin wait");
            // 4
            condition.await();
            System.out.println("end wait");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5
            lock.unlock();
        }


        // 6
        lock.lock();
        try {
            System.out.println("begin single");
            // 7
            condition.signal();
            System.out.println("end single");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8
            lock.unlock();
        }




    }
}
    