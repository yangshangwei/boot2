package com.artisan.bfzm.chapter6;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/4 23:05
 * @mark: show me the code , change the world
 */
public class ReentrantReadWriteLockList {

    //线程不安全的List
    private ArrayList<String> list = new ArrayList<String>();

    //独占锁
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    //往集合中添加元素
    public void add(String str) {
        writeLock.lock();
        try {
            list.add(str);
        } finally {
            writeLock.unlock();
        }
    }

    //删除集合中的元素
    public void remove(String str) {
        writeLock.lock();
        try {
            list.remove(str);
        } finally {
            writeLock.unlock();
        }
    }

    //根据索引获取集合中某个元素
    public String get(int index) {
        readLock.lock();
        try {
            return list.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
    