package com.artisan.lb;

import java.util.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 轮询调度算法的原理是每一次把来自用户的请求轮流分配给内部中的服务器，从1开始，直到N(内部服务器个数)，然后重新开始循环。算法的优点是其简洁性，它无需记录当前所有连接的状态，所以它是一种无状态调度。
 * @mark: show me the code , change the world
 */
public class RoundRobin {

    private static Integer pos = 0;


    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap(16);
        serverMap.putAll(Servers.serverWeightMap);

        //  取得Server地址List
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList();
        keyList.addAll(keySet);

        String server = null;
        // 更好的实现使用cas ,这里简单演示, 先使用锁
        synchronized (pos) {
            if (pos > keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }

        return server;
    }
}
    