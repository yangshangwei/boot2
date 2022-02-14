package com.artisan.bfzm.chapter10;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/19 23:05
 * @mark: show me the code , change the world
 */
public class DelayQueueTest {

    static class DelayedEle implements Delayed {

        private final long delayTime; //延迟时间
        private final long expire;  //到期时间
        private String data;   //数据

        public DelayedEle(long delay, String data) {
            delayTime = delay;
            this.data = data;
            expire = System.currentTimeMillis() + delay;
        }

        /**
         * 剩余时间=到期时间-当前时间
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 优先队列里面优先级规则
         */
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("DelayedElement{");
            sb.append("delay=").append(delayTime);
            sb.append(", expire=").append(expire);
            sb.append(", data='").append(data).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        // 1 创建延时队列
        DelayQueue<DelayedEle> delayQueue = new DelayQueue<DelayedEle>();


        // 2 创建延时任务
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DelayedEle ele = new DelayedEle(random.nextInt(500), "task-" + i);
            delayQueue.offer(ele);
        }


        System.out.println("开始操作，delayQueue队列大小为：" + delayQueue.size());


        // 3 依次取出任务并打印
        DelayedEle delayedEle = null;

        try {
            // 3.1 循环，如果想避免虚假唤醒，则不能把全部元素都打印出来
            for (; ; ) {
                // 3.2 获取过期的任务并打印
                while ((delayedEle = delayQueue.take()) != null) {
                    System.out.println(delayedEle.toString());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
    