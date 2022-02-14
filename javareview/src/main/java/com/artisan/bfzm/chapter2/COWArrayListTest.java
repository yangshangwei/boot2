package com.artisan.bfzm.chapter2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/1 21:07
 * @mark: show me the code , change the world
 */
public class COWArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("hello");
        copyOnWriteArrayList.add("artisan");
        copyOnWriteArrayList.add("learn");
        copyOnWriteArrayList.add("ml");

        Iterator iterator = copyOnWriteArrayList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
    