package com.artisan.lb;

import java.util.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 加权随机（Weight Random）法
 * @date 2022/4/30 22:30
 * @mark: show me the code , change the world
 */
public class WeightRandom {

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap(16);
        serverMap.putAll(Servers.serverWeightMap);

        // 取得Server地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(serverList.size());

        return serverList.get(randomPos);
    }
}
    