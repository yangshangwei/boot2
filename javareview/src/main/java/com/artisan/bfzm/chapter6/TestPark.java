package com.artisan.bfzm.chapter6;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 9:24
 * @mark: show me the code , change the world
 */
public class TestPark {

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.parkTest();
    }

    private void parkTest() {
        // 调用park 挂起自己
        LockSupport.park(this);
    }
}
    