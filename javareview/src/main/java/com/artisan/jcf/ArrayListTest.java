package com.artisan.jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/14 9:42
 * @mark: show me the code , change the world
 */
public class ArrayListTest {


    public static void main(String[] args) {

        /**
         * 初始化的时候指定容量
         */
        List list = new ArrayList<>(1);
        list.add(1);
        list.add(2);
        System.out.println(list.size());

        /**
         * 默认构造函数 ，数组大小为0
         */
        list = new ArrayList();
        list.add("artisan");
        list.add("review");
        list.add("java");
        System.out.println(list.size());



        /**
         * 使用集合初始化一个ArrayList
         */
        list = new ArrayList(Arrays.asList("I" , "Love" ,"Code"));
        System.out.println(list.size());


        /**
         * 扩容对比
         */

        long begin = System.currentTimeMillis();
        // 初始化1亿的数据量
        final int number = 100000000 ;
        Object o = new Object();
        ArrayList list1 = new ArrayList<String>();
        for (int i = 0; i < number; i++) {
            list1.add(o);
        }
        System.out.println("依赖ArrayList的自动扩容机制，添加数据耗时:" +(System.currentTimeMillis() - begin));


        begin = System.currentTimeMillis();
        ArrayList list2 = new ArrayList<String>();
        // 手工扩容
        list2.ensureCapacity(number);
        for (int i = 0; i < number; i++) {
            list2.add(o);
        }
        System.out.println("手工ensureCapacity扩容后，添加数据耗时:" + (System.currentTimeMillis() - begin));


    }

}
    