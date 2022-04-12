package com.artisan;

import com.lmax.disruptor.EventFactory;

/**
 * @author 小工匠
 * @version 1.0
 * @description: Step2 构造EventFactory
 * @date 2022/4/9 7:28
 * @mark: show me the code , change the world
 */


public class MyEventFactory implements EventFactory<ArtisanMessage> {


    @Override
    public ArtisanMessage newInstance() {
        return new ArtisanMessage();
    }
}
    