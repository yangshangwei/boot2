package com.artisan.bfzm.eventbusmonitordir;

import com.artisan.bfzm.eventbus.AsyncEventBus;
import com.artisan.bfzm.eventbus.EventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 16:39
 * @mark: show me the code , change the world
 */
public class FileDirTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        final EventBus eventBus = new AsyncEventBus(executor);
        //注册
        eventBus.register(new FileChangeListener());
        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(eventBus, "C:\\Users\\artisan\\Desktop\\aaa");
        monitor.startMonitor();
    }
}
    