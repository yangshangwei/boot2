package com.artisan.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.toList;

/***************************************
 * @author:Alex Wang
 * @Date:2016/11/13 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CompletableFutureInAction3 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2, r -> {
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });

       /* CompletableFuture.supplyAsync(CompletableFutureInAction1::get, executor)
                .thenApply(CompletableFutureInAction3::multiply)
                .whenComplete((v, t) -> Optional.ofNullable(v).ifPresent(System.out::println));*/

        List<Integer> productionIDs = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> result = productionIDs
                .stream()
                .map(i -> CompletableFuture.supplyAsync(() -> queryProduction(i), executor))
                .map(future -> future.thenApply(CompletableFutureInAction3::multiply))
                .map(CompletableFuture::join).collect(toList());

        System.out.println(result);
    }

    private static double multiply(double value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value * 10d;
    }

    private static double queryProduction(int i) {
        return CompletableFutureInAction1.get();
    }
}
