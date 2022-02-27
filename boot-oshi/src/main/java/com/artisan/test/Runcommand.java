package com.artisan.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/26 18:50
 * @mark: show me the code , change the world
 */
public class Runcommand {


    public static String runCommand(String CMD) {
        String info = "";
        try {
            Process pos = Runtime.getRuntime().exec(CMD);
            pos.waitFor();
            InputStreamReader isr = new InputStreamReader(pos.getInputStream());
            LineNumberReader lnr = new LineNumberReader(isr);
            String line = "";
            while ((line = lnr.readLine()) != null) {
                info = info + line + "\n";
            }
        } catch (IOException e) {
            info = e.toString();
        } catch (Exception e) {
            info = e.toString();
        }
        return info;
    }
}
    