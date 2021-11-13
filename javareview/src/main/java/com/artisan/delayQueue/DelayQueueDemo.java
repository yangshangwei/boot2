package com.artisan.delayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/2 22:51
 * @mark: show me the code , change the world
 */
public class DelayQueueDemo {

    public static void main(String[] args) {

        // 模拟数据
        List<String> list = new ArrayList<>();
        list.add("Ticket-1");
        list.add("Ticket-2");
        list.add("Ticket-3");
        list.add("Ticket-4");
        list.add("Ticket-5");

        // 延时队列
        DelayQueue<TicketDelay> queue = new DelayQueue<>();


        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            //延迟2秒取出
            queue.put(new TicketDelay(list.get(i), TimeUnit.NANOSECONDS.convert(2, TimeUnit.SECONDS)));
            System.out.println("biubiubiu ~ " + (System.currentTimeMillis() - start) + " MilliSeconds ");

            try {
                queue.take().doSomething();
                System.out.println("biubiubiu  " + (System.currentTimeMillis() - start) + " MilliSeconds 取到了数据，开始后执行业务操作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===========================\n" );
        }
    }
}
    