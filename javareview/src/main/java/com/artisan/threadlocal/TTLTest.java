package com.artisan.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TTLTest {

    /**

     * 模拟tomcat线程池

     */

    private static ExecutorService tomcatExecutors = Executors.newFixedThreadPool(10);

    /**

     * 业务线程池，默认Control中异步任务执行线程池

     */

    private static ExecutorService businessExecutors = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(4)); // 使用ttl线程池，该框架的使用，请查阅官方文档。

    /**

     * 线程上下文环境，模拟在Control这一层，设置环境变量，然后在这里提交一个异步任务，模拟在子线程中，是否可以访问到刚设置的环境变量值。

     */

    private static TransmittableThreadLocal<Integer> requestIdThreadLocal = new TransmittableThreadLocal<>();

// private static InheritableThreadLocal<Integer> requestIdThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        for(int i = 0; i < 10; i ++ ) {

            tomcatExecutors.submit(new ControlThread(i));

        }

        //简单粗暴的关闭线程池
        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        businessExecutors.shutdown();

        tomcatExecutors.shutdown();

    }

    /**

     * 模拟Control任务

     */

    static class ControlThread implements Runnable {

        private int i;

        public ControlThread(int i) {

            this.i = i;

        }

        @Override

        public void run() {

            System.out.println(Thread.currentThread().getName() + ":" + i);

            requestIdThreadLocal.set(i);

            //使用线程池异步处理任务
            businessExecutors.submit(new BusinessTask(Thread.currentThread().getName()));

        }

    }

    /**

     * 业务任务，主要是模拟在Control控制层，提交任务到线程池执行

     */

    static class BusinessTask implements Runnable {

        private String parentThreadName;

        public BusinessTask(String parentThreadName) {
            this.parentThreadName = parentThreadName;
        }

        @Override

        public void run() {

            //如果与上面的能对应上来，则说明正确，否则失败
            System.out.println("parentThreadName:" + parentThreadName + ":" + requestIdThreadLocal.get());

        }

    }
}
    