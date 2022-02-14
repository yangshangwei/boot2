package com.artisan.bfzm.chapter2;

import java.util.Random;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/28 23:05
 * @mark: show me the code , change the world
 */
public class RandomTest {

    public static void main(String[] args) {
        // 1
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // 2
            System.out.println(random.nextInt(5));
        }

    }
}
    