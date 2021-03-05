package com.artisan.java8.testDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/5 0:22
 * @mark: show me the code , change the world
 */
public class DateInJava8 {


    public static void main(String[] args) throws ParseException, InterruptedException {

        Date date = new Date();
        System.out.println(date);


        /**
         *  模拟SimpleDateFormat 的线程安全问题
         *
         *  Exception in thread "Thread-30" java.lang.NumberFormatException: multiple points
         *
         *  Exception in thread "Thread-24" java.lang.NumberFormatException: For input string: "E.250214E4"
         *
         */
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

        for (int i = 0; i < 100; i++) {
             new Thread(() -> {
                 for (int j = 0; j < 20; j++) {
                     try {
                         String format = sdf.format(date);
                         Date d = sdf.parse(format);
                         System.out.println(d);
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                 }
             }).start();
        }


    }


}
    