package com.artisan.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/12 19:08
 * @mark: show me the code , change the world
 */
public class Test {

    public static void main(String[] args) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\artisan.out"));
//        Artisan artisan = new Artisan();
//        artisan.setAge(18);
//        artisan.setName("artisan");
//        objectOutputStream.writeObject(artisan);

        ArtisanNoSerial artisanNoSerial = new ArtisanNoSerial();
        artisanNoSerial.setAge(18);
        artisanNoSerial.setName("artisan");
        objectOutputStream.writeObject(artisanNoSerial);


        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
    