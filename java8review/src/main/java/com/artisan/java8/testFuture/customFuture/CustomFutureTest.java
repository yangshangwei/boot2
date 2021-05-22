package com.artisan.java8.testFuture.customFuture;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/4/5 9:40
 * @mark: show me the code , change the world
 */
public class CustomFutureTest<T> {


    public static <T> CustomFutureInterface<T> invoke(CustomCallable<T> callable){

        // 使用引用，传递结果
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean isDone = new AtomicBoolean(false);

        // 开启子线程，执行异步任务
        new Thread(()->{
            T t = callable.doAction();
            // 在子线程中将结果封装到原子类中，便于其他线程获取
            result.set(t);
            isDone.set(true);

        }).start();


        CustomFutureInterface<T> tCustomFutureInterface = new CustomFutureInterface<T>() {
            @Override
            public T get() {
                return result.get();
            }

            @Override
            public Boolean isFinished() {
                return isDone.get();
            }
        } ;
        return tCustomFutureInterface;
    }

    /**
     *  同步阻塞方法
     * @param callable
     * @param <T>
     * @return
     */
    public static <T>  T block(CustomCallable<T> callable){
        return callable.doAction();
    }

    public static void main(String[] args) {

        CustomFutureInterface<String> future = invoke(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                return "I'm Error";

            }
            return "I'm value";
        });


        System.out.println("获取子线程的返回结果: " + future.get());

        while(!future.isFinished()) {

            try {
                System.out.println("子线程 没有结束，休眠1S...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程执行结束了，获取子线程的返回结果..."  + future.get());


        System.out.println(" ");

        System.out.println("同步测试ing...............start");
        long begin = System.currentTimeMillis();
        //测试同步
        String result = block(
                () -> {
                    {
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (InterruptedException e) {
                            return "I'm Error";
                        }
                        return "I'm value sync";
                    }
                });
        System.out.println("同步测试ing...............end  cost " + (System.currentTimeMillis() - begin));

        System.out.println("返回结果: " + result);


    }



}
    