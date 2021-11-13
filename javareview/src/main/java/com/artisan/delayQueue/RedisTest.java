package com.artisan.delayQueue;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/4 21:38
 * @mark: show me the code , change the world
 */
public class RedisTest {

    private static final String ADDR = "127.0.0.1";
    private static final int PORT = 6379;
    private static JedisPool jedis = new JedisPool(ADDR, PORT);
    private static RedisSub sub = new RedisSub();

    public static void init() {
        new Thread(() -> jedis.getResource().subscribe(sub, "__keyevent@0__:expired")).start();
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        for (int i = 0; i < 10; i++) {
            String orderId = "OID000000" + i;
            jedis.getResource().setex(orderId, 3, orderId);
            System.out.println(System.currentTimeMillis() + "ms:" + orderId + "订单生成");
        }
    }

    static class RedisSub extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println(System.currentTimeMillis() + "ms:" + message + "订单取消");
        }
    }
}
    