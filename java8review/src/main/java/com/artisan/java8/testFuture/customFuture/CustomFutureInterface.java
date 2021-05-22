package com.artisan.java8.testFuture.customFuture;

public interface CustomFutureInterface<T> {


    T get();

    Boolean isFinished();

}
