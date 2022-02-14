package com.artisan;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/29 10:24
 * @mark: show me the code , change the world
 */
public class LogbackLogger implements ILogger{

    @Override
    public void info(String message) {
        System.out.println("Logback 实现 info->" + message);
    }

    @Override
    public void debug(String message) {
        System.out.println("Logback 实现 debug->" + message);
    }
}
    