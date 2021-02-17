package com.artisan.springkafka.producer;

import com.artisan.springkafka.domain.MessageMock;
import com.artisan.springkafka.constants.TOPIC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/17 22:25
 * @mark: show me the code , change the world
 */

@Component
public class ArtisanProducerMock {


    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate ;


    public SendResult sendMsgSync() throws ExecutionException, InterruptedException {
        // 模拟发送的消息
        Integer id = new Random().nextInt(100);
        MessageMock messageMock = new MessageMock(id,"artisanTestMessage-" + id);
        // 同步等待
       return  kafkaTemplate.send(TOPIC.TOPIC, messageMock).get();
    }


}
    