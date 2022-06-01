package com.artisan.lb;

import java.util.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 加权轮询（Weight Round Robin）法
 * @mark: show me the code , change the world
 */
public class WeightRoundRobin {
    private static Integer pos;


    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap(16);
        serverMap.putAll(Servers.serverWeightMap);

        // 取得Server地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<String>();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        String server = null;
        synchronized (pos) {
            if (pos > keySet.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos++;
        }

        return server;
    }
}
    