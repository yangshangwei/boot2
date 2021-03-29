package com.artisan.java8;

import java.util.stream.IntStream;

/**
 * Created by wangwenjun on 2016/10/22.
 */
public class NumericStream {

    public static void main(String[] args) {
        /*Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        IntStream intStream = stream.mapToInt(i -> i.intValue());

        int result = intStream.filter(i -> i > 3).sum();

        System.out.println(result);*/


        int a = 9;

        //1..1000
        //result int[a,b,c];

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));

        System.out.println("=======================");


        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));
    }
}
