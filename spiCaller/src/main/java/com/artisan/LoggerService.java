package com.artisan;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/11/29 9:35
 * @mark: show me the code , change the world
 */
public class LoggerService {

    private static final LoggerService loggerService = new LoggerService();

    private final ILogger logger;

    private final List<ILogger> loggerList;


    private LoggerService() {
        ServiceLoader<ILogger> loggers = ServiceLoader.load(ILogger.class);

        List<ILogger> list = new LinkedList<>();

        for (ILogger logger : loggers) {
            list.add(logger);
        }

        loggerList = list;

        if (!loggerList.isEmpty()) {
            logger = loggerList.get(0);
        } else {
            logger = null;
        }
    }


    public static LoggerService getLoggerService() {
        return loggerService;
    }


    public void info(String msg) {
        if (logger == null) {
            System.out.println("INFO-未发现Provider");
        } else {
            logger.info(msg);
        }
    }


    public void debug(String msg) {
        if (loggerList.isEmpty()) {
            System.out.println("Debug-未发现Provider");
        } else {
            logger.debug(msg);
        }
    }
}
    