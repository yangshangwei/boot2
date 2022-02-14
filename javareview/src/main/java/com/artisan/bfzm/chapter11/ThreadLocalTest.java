package com.artisan.bfzm.chapter11;


import java.util.concurrent.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/21 8:55
 * @mark: show me the code , change the world
 */
public class ThreadLocalTest {

    static class LocalVariable {
        private Long[] variable = new Long[1024 * 1024];

//        byte[] bytes = new byte[1024 * 1024 * 10];
    }



    // 1
    final static ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>());

    // 2
    final static ThreadLocal<LocalVariable>  tl = new ThreadLocal<LocalVariable>();



    public static void main(String[] args) throws InterruptedException {
        // 3
        for (int i = 0; i < 100; i++) {
            tpe.submit(()->{
                // 4
                tl.set(new LocalVariable());
                // 5
                System.out.println("ThreadLocal set完毕");
                tl.remove();
            });
            Thread.sleep(1000);
        }

        // 6
        System.out.println("线程池执行完毕");
    }
}
    