package com.artisan.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/12 19:09
 * @mark: show me the code , change the world
 */
public class Test2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\artisan.out"));
        Artisan art = (Artisan) objectInputStream.readObject();
        System.out.println("name="+art.getName());
    }
}
    