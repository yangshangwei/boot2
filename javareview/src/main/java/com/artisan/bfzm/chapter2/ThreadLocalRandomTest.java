package com.artisan.bfzm.chapter2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/28 23:28
 * @mark: show me the code , change the world
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        // 10 获取一个随机数生成器
        ThreadLocalRandom tr = ThreadLocalRandom.current();

        // 11 输出10个（包括0 不包括5）之间的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(tr.nextInt(5));
        }
    }
}
    