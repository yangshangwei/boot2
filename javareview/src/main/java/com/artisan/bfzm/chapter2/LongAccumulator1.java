package com.artisan.bfzm.chapter2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/1 0:02
 * @mark: show me the code , change the world
 */
public class LongAccumulator1 {

    public static void main(String[] args) {
        testAccumulate();
    }

    private static void testAccumulate() {
        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 100)
                .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));



        System.out.format("Add: %d\n", accumulator.getThenReset());

        executor.shutdown();
    }
}
    