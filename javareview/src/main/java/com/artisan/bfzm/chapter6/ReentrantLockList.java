package com.artisan.bfzm.chapter6;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/4 22:05
 * @mark: show me the code , change the world
 */
public class ReentrantLockList {

    //线程不安全的List
    private ArrayList<String> list = new ArrayList<String>();

    //独占锁,默认是非公平锁，传入true可以是公平锁
    private volatile ReentrantLock lock = new ReentrantLock();

    //往集合中添加元素
    public void add(String str) {
        lock.lock();
        try {
            list.add(str);
        } finally {
            lock.unlock();
        }
    }

    //删除集合中的元素
    public void remove(String str) {
        lock.lock();
        try {
            list.remove(str);
        } finally {
            lock.unlock();
        }
    }

    //根据索引获取集合中某个元素
    public String get(int index) {
        lock.lock();
        try {
            return list.get(index);
        } finally {
            lock.unlock();
        }
    }
}
    