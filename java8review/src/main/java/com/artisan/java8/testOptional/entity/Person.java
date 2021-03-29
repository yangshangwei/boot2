package com.artisan.java8.testOptional.entity;

import java.util.Optional;


public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return this.car;
    }
}
