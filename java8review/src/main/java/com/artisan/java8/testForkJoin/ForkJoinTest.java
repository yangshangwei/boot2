package com.artisan.java8.testForkJoin;


import com.artisan.java8.AccumulatorRecursiveAction;
import com.artisan.java8.AccumulatorRecursiveTask;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/28 0:06
 * @mark: show me the code , change the world
 */
public class ForkJoinTest {

    private static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        System.out.println("result=> " + calc());
        System.out.println("result=> " + calcByStream());


        AccumulatorRecursiveTask task = new AccumulatorRecursiveTask(0, data.length, data);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(task);
        System.out.println("AccumulatorRecursiveTask >>" + result);


        AccumulatorRecursiveAction action = new AccumulatorRecursiveAction(0, data.length, data);
        forkJoinPool.invoke(action);
        System.out.println("AccumulatorRecursiveAction >>" + AccumulatorRecursiveAction.AccumulatorHelper.getResult());
    }


    private static int calc() {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }


    private static Long calcByStream() {
        return LongStream.rangeClosed(0,10).reduce(0, Long::sum);
    }
 }
    