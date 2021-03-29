package com.artisan.java8;

import java.util.Optional;

/***************************************
 * @author:Alex Wang
 * @Date:2016/10/25 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class OptionalInAction {

    public static void main(String[] args) {
        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);
    }

    private static String getInsuranceNameByOptional(Person person) {

        return Optional.ofNullable(person)
                .flatMap(Person::getCar).flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");
    }
}
