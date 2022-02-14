package com.artisan.bfzm.chapter2;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/28 21:44
 * @mark: show me the code , change the world
 */
public class TestWGX {

    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    public static void main(String[] args) {
        long[][] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; ++i) {
            for (int j = 0; j < COLUM_NUM; ++j) {
                array[i][j] = i * 2 + j;
            }
        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time:" + cacheTime);
    }

}
    