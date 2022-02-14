package com.artisan.bfzm.chapter11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/21 14:56
 * @mark: show me the code , change the world
 */
public class SimpleDateFormatTest {




    public static void main(String[] args) {
        // 2 开启多个线程，
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                // 3 使用单例日期解析文本
                System.out.println(LocalDateTime.parse("2021-11-19 15:15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            });
            thread.start();
        }

    }
}
    