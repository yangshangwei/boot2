package com.artisan.java8;

import java.util.Optional;

/***************************************
 * @author:Alex Wang
 * @Date:2016/10/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Person {

    private Optional<Car> car;

    private int age ;

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return this.car;
    }
}
