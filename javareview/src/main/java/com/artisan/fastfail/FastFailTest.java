package com.artisan.fastfail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/1 18:44
 * @mark: show me the code , change the world
 */
public class FastFailTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String tmp = iter.next();
            System.out.println(tmp);
            if (tmp.equals("1")) {
                iter.remove();
            }
        }


    }

}
    