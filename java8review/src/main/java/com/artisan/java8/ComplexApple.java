package com.artisan.java8;

/**
 * Created by wangwenjun on 2016/10/16.
 */
public class ComplexApple
{

    private String color;

    private long weight;

    private String name;

    public ComplexApple(String color, long weight, String name) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public long getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}