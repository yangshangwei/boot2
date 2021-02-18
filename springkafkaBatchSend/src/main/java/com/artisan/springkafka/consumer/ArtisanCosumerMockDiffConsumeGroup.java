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
public class ArtisanCosumerMockDiffConsumeGroup {


    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String CONSUMER_GROUP_PREFIX = "MOCK-B" ;

    @KafkaListener(topics = TOPIC.TOPIC ,groupId = CONSUMER_GROUP_PREFIX + TOPIC.TOPIC)
    public void onMessage(MessageMock messageMock){
        logger.info("【接受到消息][线程:{} 消息内容：{}]", Thread.currentThread().getName(), messageMock);
    }

}
    