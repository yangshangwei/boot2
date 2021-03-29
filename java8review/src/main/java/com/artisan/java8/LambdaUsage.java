package com.artisan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Created by wangwenjun on 2016/10/15.
 */
public class LambdaUsage {


    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a))
                result.add(a);
        }
        return result;

    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getColor(), a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple a : source) {
            consumer.accept(a);
        }
    }

    private static void simpleBiConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple a : source) {
            consumer.accept(a, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> fun) {
        return fun.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> fun) {
        return fun.apply(color, weight);
    }


    public static void main(String[] args) {

        /*Runnable r1 = () -> System.out.println("Hello");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello"));*/


        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 150));

        List<Apple> greenList = filter(list, (apple) -> apple.getColor().equals("green"));
        System.out.println(greenList);


        List<Apple> result = filterByWeight(list, w -> w > 100);
        System.out.println(result);

        List<Apple> result2 = filterByBiPredicate(list, (s, w) -> s.equals("green") && w > 100);
        System.out.println(result2);

        System.out.println("================");
        simpleTestConsumer(list, a -> System.out.println(a));

        System.out.println("================");
        simpleBiConsumer("XXX", list, (a, s) -> System.out.println(s + a.getColor() + ":Weight=>" + a.getWeight()));

        System.out.println("================");
        String result3 = testFunction(new Apple("yellow", 100), (a) -> a.toString());
        System.out.println(result3);

        IntFunction<Double> f = i -> i * 100.0d;
        double result4 = f.apply(10);
        System.out.println("================");
        System.out.println(result4);

        System.out.println("================");
        Apple a = testBiFunction("Blue", 130, (s, w) -> new Apple(s, w));
        System.out.println(a);

        Supplier<String> s = String::new;   //method inference.
        System.out.println(s.get().getClass());

        System.out.println("================");

        Apple a2 = createApple(() -> new Apple("Green", 100));
        System.out.println(a2);

        int i = 0;

        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                //i++;
                System.out.println(i);
            }
        };*/

        Runnable r2 = () -> System.out.println(i);

        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction = Integer::parseInt;
        list.sort(Comparator.comparing(Apple::getWeight));

        Function<String, Integer> stringIntegerFunction = String::length;

//        BiConsumer<PrintStream, String> test = System.out::

        System.out.println();


        BiConsumer<Test, String> say = Test::say;

        Consumer<String> c = System.out::println;

    }

    public static void useTest(BiConsumer<Test, String> con, List<String> list) {

    }

    private static void process(Runnable r) {
        r.run();
    }

    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }

    interface Test {
        public void say(String s);
    }
}
