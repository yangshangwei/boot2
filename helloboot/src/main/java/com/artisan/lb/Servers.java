package com.artisan.lb;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */
public class Servers {

    // 服务器列表，Key代表Ip，Value代表该Ip的权重
    public static Map<String, Integer> serverWeightMap = new HashMap();

    static {
        serverWeightMap.put("172.168.1.100", 1);
        serverWeightMap.put("172.168.1.101", 1);
        // 权重为4
        serverWeightMap.put("172.168.1.102", 4);

        serverWeightMap.put("172.168.1.103", 1);
        serverWeightMap.put("172.168.1.104", 1);

        // 权重为3
        serverWeightMap.put("172.168.1.105", 3);

        serverWeightMap.put("172.168.1.106", 1);

        // 权重为2
        serverWeightMap.put("172.168.1.107", 2);

        serverWeightMap.put("172.168.1.108", 1);
        serverWeightMap.put("172.168.1.109", 1);
        serverWeightMap.put("172.168.1.110", 1);
    }
}
    