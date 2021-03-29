package com.artisan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by wangwenjun on 2016/10/18.
 */
public class SimpleStream {
    public static void main(String[] args) {
        //have a dish list (menu)

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

  /*      Stream<Dish> stream = menu.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);*/

        Stream<Dish> dishStream = Stream.of(new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        dishStream.forEach(System.out::println);

        System.out.println("=========================");

        List<String> result = menu.stream().filter(d -> {

            System.out.println("filtering->" + d.getName());
            return d.getCalories() > 300;
        })
                .map(d -> {
                    System.out.println("map->" + d.getName());
                    return d.getName();
                })
                .limit(3).collect(toList());


        System.out.println("=======================");
        System.out.println(result);

/*        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
        System.out.println(dishNamesByCollections);*/
      /*  List<String> dishNamesByStreams = getDishNamesByStream(menu);
        System.out.println(dishNamesByStreams);*/

    }

    private static List<String> getDishNamesByStream(List<Dish> menu) {
        return menu.parallelStream().filter(d -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return d.getCalories() < 400;
                }
        ).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
    }

    private static List<String> getDishNamesByCollections(List<Dish> menu) {
        List<Dish> lowCalories = new ArrayList<>();

        //filter and get calories less 400
        for (Dish d : menu) {
            if (d.getCalories() < 400)
                lowCalories.add(d);
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //sort
        Collections.sort(lowCalories, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));

        List<String> dishNameList = new ArrayList<>();
        for (Dish d : lowCalories) {
            dishNameList.add(d.getName());
        }
        return dishNameList;
    }
}
