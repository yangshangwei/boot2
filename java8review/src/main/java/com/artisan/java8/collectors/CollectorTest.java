package com.artisan.java8.collectors;

import com.artisan.java8.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/12 0:46
 * @mark: show me the code , change the world
 */
public class CollectorTest {

    public enum CaloricLevel { DIET, NORMAL, FAT }

    public  static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {

        // 你还重用求出所有菜肴热量总和的收集器，不过这次是对每一组 Dish 求和
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                else return CaloricLevel.FAT; },
                                toCollection(HashSet::new))));


        System.out.println(caloricLevelsByType);

    }

    /**
     * 你还重用求出所有菜肴热量总和的收集器，不过这次是对每一组 Dish 求和
     * @return
     */





    public static Map<Boolean, List<Dish>> part(){


        System.out.println(menu.stream().collect(groupingBy(Dish::getType)));

        // 按类型分类，获取最高热量的菜
        System.out.println(menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)),Optional::get))));




        Map<Boolean, List<Dish>> collect =  menu.stream().collect(partitioningBy(Dish::isVegetarian));


        // 素菜
        System.out.println(collect.get(true));
        // 非素菜
        System.out.println(collect.get(false));


        List<Dish> xx = menu.stream().filter(Dish::isVegetarian).collect(toList());

        // 素菜
        System.out.println(xx);



        return collect;

    }


    public static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> duobleGroup(){
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })
        ));
        System.out.println(collect);
        return collect;
    }



    public static Map<CaloricLevel, List<Dish>> group(){
        Map<CaloricLevel, List<Dish>> collect = menu.stream().collect(groupingBy(dish -> {
                    if (dish.getCalories() > 300) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }
        ));
        System.out.println(collect);
        return collect;
    }

    public static String joinMenu(List<Dish> menu)  {
        return menu.stream().map(Dish::getName).collect(joining(","));
    }

    public static IntSummaryStatistics sumInfo(List<Dish> menu)  {
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        return collect;
    }
    
    
    public static Double avg(List<Dish> menu)  {
        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        return collect;
    }

    public static Integer allCal(List<Dish> menu)  {
        Integer collect = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        return collect;
    }

    public static Optional<Dish> highCa(List<Dish> menu)  {
        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
        return collect;
    }


    public static Optional<Dish> lowC(List<Dish> menu)  {
        Optional<Dish> collect = menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
        return collect;
    }

    public static Long howManyDishes(List<Dish> menu)  {
       // return  menu.stream().count();
       return menu.stream().collect(Collectors.counting());
    }


}
    