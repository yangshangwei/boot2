package com.artisan.bfzm.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/28 20:05
 * @mark: show me the code , change the world
 */
public class TestUnSafe {

    // 1 获取 Unsafe的实例
    static final Unsafe unsafe  ;

    // 2 记录变量 state在类 Testunsafe中的偏移值
    static final long stateoffset;


    // 3 变量
    private volatile long state = 0;

    public long getState() {
        return state;
    }


    static {
        try {
           // 使用反射获取Unsafe成员变量theUnsafe
            Field field =  Unsafe.class.getDeclaredField("theUnsafe");

            // 设置为可存取
            field.setAccessible(true);

            // 获取该变量的值
            unsafe  = (Unsafe)field.get(null);

            // 获取state在TestUnSfate中的偏移量
            stateoffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }


    public static void main(String[] args) {
        // 5. 创建实例
        TestUnSafe testUnSafe = new TestUnSafe();
        System.out.println("修改前:" + testUnSafe.getState());

        // 6 设置state值为1 通过cas算法
        boolean b = unsafe.compareAndSwapLong(testUnSafe, stateoffset, 0, 1);
        System.out.println("修改  " + b);

        System.out.println("修改前:" + testUnSafe.getState());

    }

}
    