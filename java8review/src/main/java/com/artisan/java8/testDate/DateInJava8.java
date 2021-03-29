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

    private static LocalDate localDate = LocalDate.now();


    public static void main(String[] args) throws ParseException, InterruptedException {

//        Date date = new Date();
//        System.out.println(date);


        /**
         *  模拟SimpleDateFormat 的线程安全问题
         *
         *  Exception in thread "Thread-30" java.lang.NumberFormatException: multiple points
         *
         *  Exception in thread "Thread-24" java.lang.NumberFormatException: For input string: "E.250214E4"
         *
         */
//        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
//
//        for (int i = 0; i < 100; i++) {
//             new Thread(() -> {
//                 for (int j = 0; j < 20; j++) {
//                     try {
//                         String format = sdf.format(date);
//                         Date d = sdf.parse(format);
//                         System.out.println(d);
//                     } catch (ParseException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             }).start();
//        }

//        testLocalDate();
//        testLocalTime();

    //    testLocalDateTime();

//        testInstant();


//        testDuration();
//        testPeriod();

//        localDate2Date();

        testDateFormat();

//        testDateParse();
    }



    public static void localDate2Date(){
        LocalDate ld = LocalDate.now();
        System.out.println(ld.toString());
        Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println(date); // prints "Fri Mar 05 00:00:00 CST 2021"

        Date date1 = java.sql.Date.valueOf(ld);

        System.out.println(date1); // prints "2017-11-10"
    }


    public static void testLocalDate(){
        LocalDate x = LocalDate.now(); // 日期  2021-03-05
        System.out.println(x);


        LocalDate lo = LocalDate.of(2021,3,5);
        System.out.println(lo.getYear()); // 年  2021
        System.out.println(lo.getMonth()); // 月 MARCH
        System.out.println(lo.getDayOfMonth()); // 日 5

        System.out.println(lo.getDayOfYear()); // 一年中的第几天
        System.out.println(lo.getDayOfMonth());// 一个月中的第几天
        System.out.println(lo.getDayOfWeek());// 礼拜几


        System.out.println(lo.get(ChronoField.DAY_OF_MONTH));

    }


    private static void testLocalTime() {
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    private static void testLocalDateTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime time = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, time);
        System.out.println(localDateTime.toString());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    private static void testInstant() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000L);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }

    private static void testDuration() {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime beforeTime = time.minusHours(2);
        System.out.println(beforeTime);
        Duration duration = Duration.between(beforeTime,time );
        System.out.println(duration.toHours());
    }

    private static void testPeriod() {
        Period period = Period.between(LocalDate.of(2020, 5, 10),LocalDate.of(2021, 3, 4));
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    private static void testDateFormat() {
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format1);

        DateTimeFormatter mySelfFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = localDate.format(mySelfFormatter);
        System.out.println(format);
    }

    private static void testDateParse() {
        String date1 = "20210305";
        LocalDate localDate = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);
       

        DateTimeFormatter mySelfFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date2 = "2021-03-05";
        LocalDate localDate2 = LocalDate.parse(date2, mySelfFormatter);
        System.out.println(localDate2);
    }

}
