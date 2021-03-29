package com.artisan.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

/***************************************
 * @author:Alex Wang
 * @Date:2016/11/13 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class DateTest {
    public static void main(String[] args) throws ParseException, InterruptedException {
/*        Date date = new Date(116, 2, 18);
        System.out.println(date);*/

/*        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int x = 0; x < 100; x++) {
                    Date parseDate = null;
                    try {
                        parseDate = sdf.parse("20160505");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(parseDate);
                }
            }).start();
        }*/

//        testLocalDate();
//        testLocalTime();
//        combineLocalDateAndTime();
//        testInstant();
//        testDuration();
//        testPeriod();
//        testDateFormat();
        testDateParse();
    }

    private static void testLocalDate() {
        LocalDate localDate = LocalDate.of(2016, 11, 13);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());

        localDate.get(ChronoField.DAY_OF_MONTH);
    }

    private static void testLocalTime() {
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    private static void combineLocalDateAndTime() {
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
        LocalTime beforeTime = time.minusHours(1);
        Duration duration = Duration.between(time, beforeTime);
        System.out.println(duration.toHours());
    }

    private static void testPeriod() {
        Period period = Period.between(LocalDate.of(2014, 1, 10), LocalDate.of(2016, 1, 10));
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.getYears());
    }

    private static void testDateFormat() {
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
//        String format2 = localDate.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(format1);
//        System.out.println(format2);

        DateTimeFormatter mySelfFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = localDate.format(mySelfFormatter);
        System.out.println(format);
    }

    private static void testDateParse() {
        String date1 = "20161113";
        LocalDate localDate = LocalDate.parse(date1, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);
        
        DateTimeFormatter mySelfFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date2 = "2016-11-13";
        LocalDate localDate2 = LocalDate.parse(date2, mySelfFormatter);
        System.out.println(localDate2);
    }
}