package com.artisan.java8.stream;

import com.artisan.java8.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/7 8:23
 * @mark: show me the code , change the world
 */
public class StreamTest {

    public static void main(String[] args) {
        //have a dish list (menu)

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, com.artisan.java8.Dish.Type.MEAT),
                new Dish("beef", false, 700, com.artisan.java8.Dish.Type.MEAT),
                new Dish("chicken", false, 400, com.artisan.java8.Dish.Type.MEAT),
                new Dish("french fries", true, 530, com.artisan.java8.Dish.Type.OTHER),
                new Dish("rice", true, 350, com.artisan.java8.Dish.Type.OTHER),
                new Dish("season fruit", true, 120, com.artisan.java8.Dish.Type.OTHER),
                new Dish("pizza", true, 550, com.artisan.java8.Dish.Type.OTHER),
                new Dish("prawns", false, 300, com.artisan.java8.Dish.Type.FISH),
                new Dish("salmon", false, 450, com.artisan.java8.Dish.Type.FISH));


//        System.out.println(getDiskNamesByCollections(menu));
//
//        System.out.println(getDiskNamesByStream(menu));
//
//        System.out.println(getDiskNamesByParallStream(menu));
//
//
//        System.out.println(getTop3HighCalories(menu));
//
//        testConsumeMoreTime(menu);

        System.out.println(getDiskNamesByStream2(menu));
    }

    /**
     * 需求： 输出小于400的Dish的名字 , 并按照卡路里排序
     * @param dishList
     * @return
     */
    public static List<String> getDiskNamesByCollections(List<Dish> dishList){
        List<Dish> lowCalories = new ArrayList<>();


        //  filter  过滤小于400的
        for(Dish dish : dishList){
            if (dish.getCalories() < 400) {
                lowCalories.add(dish);
            }
        }

        // sort   按照卡路里排序
        Collections.sort(lowCalories,Comparator.comparingInt(Dish::getCalories));


        // 处理排序后的数据
        List<String> dishNames = new ArrayList<>();
        for (Dish dish :lowCalories){
            dishNames.add(dish.getName());
        }
        return dishNames;
    }


    /**
     * 需求： 输出小于400的Dish的名字 , 按照卡路里从第到高输出
     * @param dishList
     * @return
     */
    public static List<String> getDiskNamesByStream(List<Dish> dishList){
        return dishList.stream().filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());
    }

    public static List<String> getDiskNamesByParallStream(List<Dish> dishList){
        return dishList.parallelStream().filter(dish -> {
            try {
                Thread.sleep(1*100); // 模拟休眠，观察parallelStream是否开启了多个线程计算
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return dish.getCalories() < 400 ;
        })
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());
    }


    /**
     * 需求： 卡路里前三的dish的名字
     * @param dishList
     * @return
     */
    public static List<String> getTop3HighCalories(List<Dish> dishList){
        return dishList.stream().filter(dish->dish.getCalories()>300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * 需求： 卡路里前三的dish的名字
     * @param dishList
     * @return
     */
    public static void  test(List<Dish> dishList){
        dishList.stream().forEach(System.out::println);
    }


    /**
     * 需求： 输出小于400的Dish的名字 , 按照卡路里从第到高输出
     * @param dishList
     * @return
     */
    public static List<String> getDiskNamesByStream2(List<Dish> dishList) {
        return dishList.stream()
                .filter(dish -> {
                    System.out.println("filtering:" + dish.getName());
                    return dish.getCalories() >300 ;
                })
                .map(dish -> {
                    System.out.println("mapping:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }
}
    