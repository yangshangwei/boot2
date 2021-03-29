package com.artisan.java8.testMethodRef;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/7 11:19
 * @mark: show me the code , change the world
 */
public class CompareUtil {


    public  int compareNoramMethod(Integer o1,Integer o2){
        return o1.compareTo(o2);
    }


    public void testSelfCall(){
        Collections.sort(Arrays.asList(1,2,3), this::compareNoramMethod);
    }





    public static void main(String[] args) {

        // 实例化对象
        CompareUtil compare = new CompareUtil();

        // 传统的lambda
        Collections.sort(Arrays.asList(1,2,3),(o1,o2)->compare.compareNoramMethod(o1,o2));

        // 方法引用
        Collections.sort(Arrays.asList(1,2,3),compare::compareNoramMethod);



        Collections.sort(Arrays.asList(1,2,3), (o1, o2) -> o1.compareTo(o2));

        Collections.sort(Arrays.asList(1,2,3),Integer::compareTo);


        Artisan artisan = new Artisan("xxx",111);
        System.out.println(artisan);


    }


    static class Artisan {
        private String name ;
        private double heigh;

        public Artisan(String name, double heigh) {
            this.name = name;
            this.heigh = heigh;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getHeigh() {
            return heigh;
        }

        public void setHeigh(double heigh) {
            this.heigh = heigh;
        }

        @Override
        public String toString() {
            return "Artisan{" +
                    "name='" + name + '\'' +
                    ", heigh=" + heigh +
                    '}';
        }
    }
}
    