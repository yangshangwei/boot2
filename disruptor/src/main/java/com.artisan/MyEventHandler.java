package com.artisan;


import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 小工匠
 * @version 1.0
 * @description: Step3 构造EventHandler-消费者
 * @date 2022/4/9 7:31
 * @mark: show me the code , change the world
 */

@Slf4j
public class MyEventHandler implements EventHandler<ArtisanMessage> {

    @Override
    public void onEvent(ArtisanMessage event, long sequence, boolean endOfBatch) throws Exception {

        try {
            // 停止1000ms是为了模拟消费消息是异步的
            Thread.sleep(1000);
            log.info("消费者处理消息开始");

            if (event != null) {
                log.info("收到消息 ： " + event);
            }
        } catch (Exception e) {
            log.error("消费者处理消息失败,{}",e.getMessage());
        }
        log.info("消费者处理消息结束");

    }
}
    