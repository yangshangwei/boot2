package com.artisan.java8.stream;


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
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


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
//        System.out.println(xxxx());

//        reduce();
        System.out.println(sumCal2(menu));

    }

    // 菜单中的热量求和
    public static Integer sumCal(List<Dish> dishes){
         return dishes.stream().map(Dish::getCalories)
                 .reduce(0,Integer::sum);
    }

    public static Integer sumCal2(List<Dish> dishes){
        return dishes.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    public static Integer sumCal3(List<Dish> dishes){
        OptionalInt max = dishes.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int i = max.orElse(1);
        return i;
    }
    

    public static void reduce(){
        List<Integer> list = Arrays.asList(11,2,3);
        int sum = list.stream().reduce(0,Integer::max);
        System.out.println(sum);
    }
        /**
         * 需求：     给定一个数字列表， 找出第一个平方能被3整除的数
         */
    public static Optional<Integer> xxxx() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        return  list.stream()
                .map(x -> x *x)
                .filter(i -> i % 3 == 0)
                .findFirst();
    }

    /**
     * 需求：  找到一道素菜
     */
    public static Optional<Dish> randomVeDish(List<Dish> dishes) {
         return dishes.stream()
                 .filter(Dish::isVegetarian)
                 .findAny();
    }

    /**
     * 需求：  没有任何一个卡路里超过1000
     */
    public static void isHeass(List<Dish> dishes) {
        if (dishes.stream().noneMatch(d->d.getCalories()>=1000)){
            System.out.println("muyou ");
        }
    }


    /**
     * 需求：  看看所有热量是否都低于1000卡路里
     */
    public static void isHea(List<Dish> dishes) {
        if (dishes.stream().allMatch(d->d.getCalories()<1000)){
            System.out.println("oj8k ");
        }
    }

    /**
     * 需求：  是否包含素菜

     */
    public static void isVe(List<Dish> dishes) {
        if (dishes.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("you su cai ");
        }
    }

    /**
     * 需求：  对于一张单词表 ， 如何返回一张列表 ， 列出里面各不相同的字符呢？
     * <p>
     * 错误的写法
     *
     * @return
     */
    public static List<String[]> test() {
        List<String> list = Arrays.asList("hello", "world");
        return list.stream()
                .map(t -> t.split(" "))
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * 需求：  对于一张单词表 ， 如何返回一张列表 ， 列出里面各不相同的字符呢？
     * <p>
     * 错误的写法
     *
     * @return
     */
    public static List<Stream<String>> test2() {
        Stream<String> stream = Arrays.stream(new String[]{"hello", "world"});
        return stream.map(t -> t.split(" "))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * 需求：  对于一张单词表 ， 如何返回一张列表 ， 列出里面各不相同的字符呢？
     * <p>
     * 完美
     *
     * @return
     */
    public static List<String> test3() {
        Stream<String> stream = Arrays.stream(new String[]{"hello", "world"});
        return stream.map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        }


        /**
         * 需求：  要找出每道菜的名称有多长
         * @param dishes
         * @return
         */
        public static List<Integer> getMenuLength (List < Dish > dishes) {
            List<String> list = Arrays.asList("abc", "pear", "child", "artisan");

            return dishes.stream()
                    .map(Dish::getName)
                    .map(String::length)
                    .collect(Collectors.toList());
        }


        /**
         * 给定一个单词列表，想要返回另一个列表，显示每个单词中有几个字母。
         * @return
         */
        public static List mapping () {
            List<String> list = Arrays.asList("abc", "pear", "child", "artisan");
            return list.stream().map(String::length).collect(Collectors.toList());
        }

        public static List<String> getMenu (List < Dish > dishes) {
            return dishes.stream()
                    .map(Dish::getName)
                    .collect(Collectors.toList());
        }


        /**
         * 需求： 跳过超过300卡路里的头两道菜，并返回剩下的
         * @param dishes
         * @return
         */
        public static List<String> skipTop2Over300Carl (List < Dish > dishes) {
            return dishes.stream().filter(d -> d.getCalories() > 300)
                    .skip(2)
                    .map(Dish::getName)
                    .collect(Collectors.toList());
        }


        /**
         * 选出热量超过300卡路里的头三道菜
         * @param dishes
         * @return
         */
        public static List<String> getTop3HighCa (List < Dish > dishes) {
            return dishes.stream()
                    .filter(d -> d.getCalories() > 300)
                    .limit(3)
                    .map(Dish::getName)
                    .collect(Collectors.toList());
        }

        public static void testDistinct () {
            Arrays.asList(1, 2, 1, 3, 3, 2, 4)
                    .stream()
                    .filter(i -> i % 2 == 0)
                    .distinct()
                    .forEach(System.out::println);
        }

        /**
         * 需求：  输出所有的品类
         * @param dishList
         * @return
         */
        public static List<Dish> getCategories (List < Dish > dishList) {

            return dishList.stream()
                    .filter(Dish::isVegetarian)
                    .collect(Collectors.toList());
        }


        /**
         * 需求：  输出所有的素菜
         * @param dishList
         * @return
         */
        public static List<Dish> getDistinct (List < Dish > dishList) {

            return dishList.stream()
                    .filter(Dish::isVegetarian)
                    .collect(Collectors.toList());
        }


        /**
         * 需求：  输出各异的元素
         * @param dishList
         * @return
         */
        public static List<Boolean> getDistinctMenu (List < Dish > dishList) {

            return dishList.stream().map(Dish::isVegetarian).distinct().collect(Collectors.toList());
        }

        /**
         * 需求：  输出所有的素菜
         * @param dishList
         * @return
         */
        public static List<Dish> getVegetarianByStream (List < Dish > dishList) {

            return dishList.stream()
                    .filter(Dish::isVegetarian)
                    .collect(Collectors.toList());
        }


        /**
         * 需求： 输出小于400的Dish的名字 , 并按照卡路里排序
         * @param dishList
         * @return
         */
        public static List<String> getDiskNamesByCollections (List < Dish > dishList) {
            List<Dish> lowCalories = new ArrayList<>();


            //  filter  过滤小于400的
            for (Dish dish : dishList) {
                if (dish.getCalories() < 400) {
                    lowCalories.add(dish);
                }
            }

            // sort   按照卡路里排序
            Collections.sort(lowCalories, Comparator.comparingInt(Dish::getCalories));


            // 处理排序后的数据
            List<String> dishNames = new ArrayList<>();
            for (Dish dish : lowCalories) {
                dishNames.add(dish.getName());
            }
            return dishNames;
        }


        /**
         * 需求： 输出小于400的Dish的名字 , 按照卡路里从第到高输出
         * @param dishList
         * @return
         */
        public static List<String> getDiskNamesByStream (List < Dish > dishList) {
            return dishList.stream().filter(dish -> dish.getCalories() < 400)
                    .sorted(Comparator.comparing(Dish::getCalories))
                    .map(Dish::getName).collect(Collectors.toList());
        }

        public static List<String> getDiskNamesByParallStream (List < Dish > dishList) {
            return dishList.parallelStream().filter(dish -> {
                try {
                    Thread.sleep(1 * 100); // 模拟休眠，观察parallelStream是否开启了多个线程计算
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return dish.getCalories() < 400;
            })
                    .sorted(Comparator.comparing(Dish::getCalories))
                    .map(Dish::getName).collect(Collectors.toList());
        }


        /**
         * 需求： 卡路里前三的dish的名字
         * @param dishList
         * @return
         */
        public static List<String> getTop3HighCalories (List < Dish > dishList) {
            return dishList.stream().filter(dish -> dish.getCalories() > 300)
                    .map(Dish::getName)
                    .limit(3)
                    .collect(Collectors.toList());
        }

        /**
         * 需求： 卡路里前三的dish的名字
         * @param dishList
         * @return
         */
        public static void test (List < Dish > dishList) {
            dishList.stream().forEach(System.out::println);
        }


        /**
         * 需求： 输出小于400的Dish的名字 , 按照卡路里从第到高输出
         * @param dishList
         * @return
         */
        public static List<String> getDiskNamesByStream2 (List < Dish > dishList) {
            return dishList.stream()
                    .filter(dish -> {
                        System.out.println("filtering:" + dish.getName());
                        return dish.getCalories() > 300;
                    })
                    .map(dish -> {
                        System.out.println("mapping:" + dish.getName());
                        return dish.getName();
                    })
                    .limit(3)
                    .collect(Collectors.toList());
        }
    }
    