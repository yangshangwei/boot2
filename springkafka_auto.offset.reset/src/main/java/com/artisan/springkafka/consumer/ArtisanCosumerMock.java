package com.artisan.springkafka.consumer;

import com.artisan.springkafka.domain.MessageMock;
import com.artisan.springkafka.constants.TOPIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/17 22:33
 * @mark: show me the code , change the world
 */

@Component
public class ArtisanCosumerMock {


    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final String CONSUMER_GROUP_PREFIX = "ConsumerGroup-" ;

    /**
     * 消费者的groupId ,每次启动都通过SPEL 随机一个出来，确保每次都是一个新的消费组 用于测试 auto.offset.reset 参数 设置为 earliest的情况
     * @param messageMock
     */
    @KafkaListener(topics = TOPIC.TOPIC ,groupId = CONSUMER_GROUP_PREFIX + TOPIC.TOPIC +  "-" + "#{T(java.util.UUID).randomUUID()})")
    public void onMessage(MessageMock messageMock){
        logger.info("【接受到消息][线程:{} 消息内容：{}]", Thread.currentThread().getName(), messageMock);
    }

}
    