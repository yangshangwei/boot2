package com.artisan.delayQueue;

import java.util.Calendar;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/4 21:04
 * @mark: show me the code , change the world
 */
public class RedisDelayQueue {

    private static final String ADDR = "127.0.0.1";
    private static final int PORT = 6379;
    private static JedisPool jedisPool = new JedisPool(ADDR, PORT);

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 生产者,生成5个订单放进去
     */
    public void productionDelayMessage() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            //延迟3秒
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.SECOND, 3);
            int second3later = (int) (cal1.getTimeInMillis() / 1000);
//            System.out.println("score :" + second3later);

            RedisDelayQueue.getJedis().zadd("OrderId", second3later, "ARTISAN_ID_" + i);
            System.out.println(System.currentTimeMillis() + "ms:redis生成了订单：订单ID为" + "ARTISAN_ID_" + i);
        }
        System.out.println("cost :" + ( System.currentTimeMillis() - begin) + "ms");
    }

    /**
     * 消费者，取订单
     */
    public void consumerDelayMessage() {
        Jedis jedis = RedisDelayQueue.getJedis();
        while (true) {
            Set<Tuple> items = jedis.zrangeWithScores("OrderId", 0, 1);
            if (items == null || items.isEmpty()) {
                System.out.println("当前没有等待的任务");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            int score = (int) ((Tuple) items.toArray()[0]).getScore();
            Calendar cal = Calendar.getInstance();
            int nowSecond = (int) (cal.getTimeInMillis() / 1000);
            if (nowSecond >= score) {
                String orderId = ((Tuple) items.toArray()[0]).getElement();
//                jedis.zrem("OrderId", orderId);
//                System.out.println(System.currentTimeMillis() + "ms:redis消费了一个任务：消费的订单Id为" + orderId);

                Long num = jedis.zrem("OrderId", orderId);
                if( num != null && num>0){
                    System.out.println(System.currentTimeMillis()+"ms:redis消费了一个任务：消费的订单OrderId为"+orderId);
                }
            }
        }
    }

    public static void main(String[] args) {
        RedisDelayQueue appTest = new RedisDelayQueue();
        appTest.productionDelayMessage();
        appTest.consumerDelayMessage();
    }
}
    