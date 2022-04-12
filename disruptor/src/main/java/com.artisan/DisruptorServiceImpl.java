package com.artisan;

import com.lmax.disruptor.RingBuffer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/4/9 7:50
 * @mark: show me the code , change the world
 */


@Slf4j
@Component
@Service
public class DisruptorServiceImpl implements DisruptorMQService {

    @Autowired
    private RingBuffer<ArtisanMessage> artisanMessageRingBuffer;


    @Override
    public void testSendMessage(String message) {
        log.info("将要发送的消息为: {}  ", message);
        //获取下一个Event槽的下标
        long sequence = artisanMessageRingBuffer.next();

        try {
            //给Event填充数据
            ArtisanMessage event = artisanMessageRingBuffer.get(sequence);
            event.setMessage(message);
            log.info("向消息队列中添加消息： {} ", event);
        } catch (Exception e) {
            log.error("failed to add event to messageModelRingBuffer for : e = {},{}", e, e.getMessage());
        } finally {
            //发布Event，激活观察者去消费，将sequence传递给改消费者
            //注意最后的publish方法必须放在finally中以确保必须得到调用；如果某个请求的sequence未被提交将会堵塞后续的发布操作或者其他的producer
            artisanMessageRingBuffer.publish(sequence);
            log.info("发布Event结束,等待消费...." );

        }
    }
}
    