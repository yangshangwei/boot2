package com.artisan.java8.testLambda;

import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.View;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/7 9:31
 * @mark: show me the code , change the world
 */
public class LambdaTest {


    public static void main(String[] args) {


        /**
         * 无参的形式
         */

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("artisan learn lambda");
            }
        }).start();


        /**
         * () -> {
         *     执行语句;
         *  }
         *
         *  如果 执行的内容仅有一句，{} 也是可以省略的。  执行语句后无标点符号
         *
         *  () ->
         *
         */
        new Thread(()->System.out.println("artisan learn lambda" )).start();




        List<Integer> list = Arrays.asList(1, 2, 3);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(list, (o1,o2) -> {
            return o1.compareTo(o2);
        });


        Collections.sort(list, (o1,o2) -> o1.compareTo(o2));


        Collections.sort(list, Integer::compareTo);
    }



}
    