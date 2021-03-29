package com.artisan.java8.parralle;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/21 11:38
 * @mark: show me the code , change the world
 */
public class ParallelTest {


    public static void main(String[] args) {
//        System.out.println(measureSumPerformance(ParallelTest::adderByNormal,10000000) + "ms");
//        System.out.println(measureSumPerformance(ParallelTest::adderByStream,10000000)+ "ms");
//        System.out.println(measureSumPerformance(ParallelTest::adderByStreamParallel,10000000)+ "ms");
//        System.out.println(measureSumPerformance(ParallelTest::adderByLongStreamRangeClosed,10000000)+ "ms");
//
//        System.out.println(measureSumPerformance(ParallelTest::adderByLongStreamRangeClosedParallel,10000000)+ "ms");

        System.out.println(measureSumPerformance(ParallelTest::sideEffectParallelSum,10000000)+ "ms");

    }



    private static long measureSumPerformance(Function<Long, Long> adder, long limit) {
        long fastest = Long.MAX_VALUE;
        // 运行10次，找最快的一次
        for (int i = 0; i < 10; i++) {
            long startTimestamp = System.currentTimeMillis();
            Long apply = adder.apply(limit);
            System.out.println(apply);
            long duration = System.currentTimeMillis() - startTimestamp;
            if ((duration < fastest)) {
                fastest = duration;
            }
        }
        return fastest;
    }


    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public  static Long adderByLongStreamRangeClosedParallel(Long limit){
        return LongStream.rangeClosed(1,limit)
                .parallel()
                .reduce(0,Long::sum);
    }

    public static Long adderByLongStreamRangeClosed(Long limit){
        return LongStream.rangeClosed(1,limit)
                .reduce(0,Long::sum);
    }


    public static Long adderByStream(Long limit){
        return Stream.iterate(1L,i->i+1)
                .limit(limit)
                .reduce(0L, Long::sum);
    }


    public static Long adderByStreamParallel(Long limit){
        return Stream.iterate(1L,i->i+1)
                .limit(limit)
                .parallel()
                .reduce(0L, Long::sum);
    }



    public static Long adderByNormal(Long limit){
        Long result = 0L;

        for (int i = 0; i <= limit; i++) {
            result += i ;
        }

        return result ;
    }
    public static class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }
    }
}
    