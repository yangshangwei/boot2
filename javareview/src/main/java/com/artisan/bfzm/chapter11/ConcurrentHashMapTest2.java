package com.artisan.bfzm.chapter11;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/21 10:46
 * @mark: show me the code , change the world
 */
public class ConcurrentHashMapTest2 {
    // 1 创建Map , key为注册中心地址，value为客户端列表
    private static ConcurrentHashMap<String, List<String>> registMap = new ConcurrentHashMap<>();

    private static final String REGIST_SERVER_A = "注册中心A";
    private static final String REGIST_SERVER_B = "注册中心B";

    public static void main(String[] args) {

        // 2  注册 REGIST_SERVER_A
        Thread threadOne =new Thread(()->{
            List<String> list = new ArrayList<>();
            list.add("客户端一");
            list.add("客户端二");
            // 若果原集合不为空，则追加新的集合
            List<String> oldList = registMap.putIfAbsent(REGIST_SERVER_A, list);
            if (null != oldList){
                oldList.addAll(list);
            }

            System.out.println( "注册信息:" + JSON.toJSONString(registMap));
        });

        // 3 注册 REGIST_SERVER_A
        Thread threadTwo =new Thread(()->{
            List<String> list = new ArrayList<>();
            list.add("客户端三");
            list.add("客户端四");
            List<String> oldList = registMap.putIfAbsent(REGIST_SERVER_A, list);
            // 若果原集合不为空，则追加新的集合
            if (!CollectionUtils.isEmpty(oldList)){
                oldList.addAll(list);
            }
            System.out.println( "注册信息:" + JSON.toJSONString(registMap));
        });


        // 4 注册 REGIST_SERVER_B
        Thread threadThree =new Thread(()->{
            List<String> list = new ArrayList<>();
            list.add("客户端五");
            list.add("客户端六");
            List<String> oldList = registMap.putIfAbsent(REGIST_SERVER_B, list);
            if (!CollectionUtils.isEmpty(oldList)){
                oldList.addAll(list);
            }
            System.out.println("注册信息:" + JSON.toJSONString(registMap));
        });


        // 5 启动注册
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

}
    