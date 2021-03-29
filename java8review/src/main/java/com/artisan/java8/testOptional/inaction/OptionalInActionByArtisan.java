package com.artisan.java8.testOptional.inaction;

import com.artisan.java8.Car;
import com.artisan.java8.Insurance;
import com.artisan.java8.Person;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/14 10:23
 * @mark: show me the code , change the world
 */
public class OptionalInActionByArtisan {

    public static void main(String[] args) {




    }

    //   找出年龄大于或者等于 minAge 参数的 Person 所对应的保险公司列表
    public String getCarInsuranceName(Optional<Person> person, int minAge){

       return  person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");

    }






}
    