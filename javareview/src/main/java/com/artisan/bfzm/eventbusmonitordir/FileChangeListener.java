package com.artisan.bfzm.eventbusmonitordir;

import com.artisan.bfzm.eventbus.Subscribe;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 16:39
 * @mark: show me the code , change the world
 */
public class FileChangeListener {

    @Subscribe
    public void onChange(FileChangeEvent event) {
        System.out.printf("%s-%s-%s\n", Thread.currentThread().getName(),event.getPath(), event.getKind());
    }
}
    