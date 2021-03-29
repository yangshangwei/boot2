package com.artisan.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/***************************************
 * @author:Alex Wang
 * @Date:2016/10/30 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ParallelProcessing {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(ParallelProcessing::normalAdd, 100_000_000) + " MS");
        System.out.println("The best process time(iterateStream)=>" + measureSumPerformance(ParallelProcessing::iterateStream, 10_000_000) + " MS");
        System.out.println("The best process time(parallelStream)=>" + measureSumPerformance(ParallelProcessing::parallelStream, 10_000_000) + " MS");
        System.out.println("The best process time(parallelStream2)=>" + measureSumPerformance(ParallelProcessing::parallelStream2, 10_000_000) + " MS");
        System.out.println("The best process time(parallelStream3)=>" + measureSumPerformance(ParallelProcessing::parallelStream3, 100_000_000) + " MS");
    }

    private static long measureSumPerformance(Function<Long, Long> adder, long limit) {
        long fastest = Long.MAX_VALUE;
        // 运行10次，找最快的一次
        for (int i = 0; i < 10; i++) {
            long startTimestamp = System.currentTimeMillis();
             adder.apply(limit);
            long duration = System.currentTimeMillis() - startTimestamp;
            if ((duration < fastest)) {
                fastest = duration;
            }
        }
        return fastest;
    }


    private static long iterateStream(long limit) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream(long limit) {
        // 并行
        return Stream.iterate(1L, i -> i + 1).parallel()
                .limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream2(long limit) {

        // mapToLong 拆箱
        return Stream.iterate(1L, i -> i + 1).mapToLong(Long::longValue).parallel()
                .limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream3(long limit) {
        // 并行
        return LongStream.rangeClosed(1, limit).parallel().reduce(0L, Long::sum);
    }

    private static long normalAdd(long limit) {
        long result = 0L;
        for (long i = 1L; i < limit; i++) {
            result += i;
        }
        return result;
    }
}