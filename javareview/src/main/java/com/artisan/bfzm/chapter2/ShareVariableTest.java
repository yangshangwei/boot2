package com.artisan.bfzm.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/27 10:23
 * @mark: show me the code , change the world
 */
public class ShareVariableTest {

    private int count;



    public synchronized int getCount() {
        return count;
    }

    public synchronized  void add() {
        count++;
    }
}
    