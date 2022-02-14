package com.artisan;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/29 10:10
 * @mark: show me the code , change the world
 */
public class CallMain {

    public static void main(String[] args) {
        LoggerService loggerService = LoggerService.getLoggerService();

        loggerService.info("test info message");
        loggerService.debug("test debug message");

    }
}
    