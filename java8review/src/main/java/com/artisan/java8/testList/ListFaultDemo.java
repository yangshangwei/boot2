package com.artisan.java8.testList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/22 21:31
 * @mark: show me the code , change the world
 */
public class ListFaultDemo {


    public static void main(String[] args) {
//        arraysAsList();
        subList();
    }

    /**
     * Arrays.asList的注意事项
     */
   public static void  arraysAsList(){

       List<Integer> list = Arrays.asList(1, 2,3,4,5);

       list.clear();

   }


    /**
     * subList的注意事项
     */
    public static void  subList(){

        List<String> list = new ArrayList<>();
        list.add("小工匠");
        list.add("Java");
        list.add("AI");
        list.add("Big Data");
        list.add("LOT");

        // 基本使用
        List<String> targetList = list.subList(2, 3);

        System.out.println(list);
        System.out.println(targetList);

        //【非结构性修改】 修改下子集合targetList中某一元素的值，会影响到原集合中的值。
        targetList.set(0,"modify data");

        System.out.println(list);
        System.out.println(targetList);


    }

}
    