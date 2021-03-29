package com.artisan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangwenjun on 2016/10/12.
 */
public class FilterApple {


    @FunctionalInterface
    public interface AppleFilter {

        boolean filter(Apple apple);

    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple))
                list.add(apple);
        }
        return list;
    }

    public static class GreenAnd160WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }

    public static class YellowLess150WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("yellow") && apple.getWeight() < 150);
        }
    }

    public static List<Apple> findGreenApple(List<Apple> apples) {

        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size() == 2;

       /* List<Apple> greenApples = findApple(list, "green");
        System.out.println(greenApples);

        List<Apple> redApples = findApple(list, "red");
        System.out.println(redApples);*/
/*
        List<Apple> result = findApple(list, new GreenAnd160WeightFilter());
        System.out.println(result);

        List<Apple> yellowList = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });

        System.out.println(yellowList);*/

        List<Apple> lambdaResult = findApple(list, apple -> apple.getColor().equals("green"));

        System.out.println(lambdaResult);

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();


        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();


        Thread.currentThread().join();
    }


}
