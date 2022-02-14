package com.artisan.bfzm.chapter2;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/27 10:43
 * @mark: show me the code , change the world
 */
public class KeCongRuLockDemo {


    public synchronized  void lockA(){
        System.out.println("lockA");
    }

    public synchronized  void lockB(){
        System.out.println("lockB ， then call lockA");
        lockA();
    }

    public static void main(String[] args) {
        KeCongRuLockDemo lockDemo = new KeCongRuLockDemo();
        lockDemo.lockB();

    }
}
    