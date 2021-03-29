package com.artisan.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/3/10 17:07
 * @mark: show me the code , change the world
 */
public class FileGenerator {

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = null ;

        for (int i = 0; i < 5; i++) {
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\artisan\\Desktop\\Test\\" + i + ".txt"));
            bufferedWriter.write(i+"xxx");
            bufferedWriter.close();
        }
    }
}
    