package com.artisan.springkafka.producer;

import com.artisan.springkafka.constants.TOPIC;
import com.artisan.springkafka.domain.MessageMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

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


    /**
     * 同步发送
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public SendResult sendMsgSync() throws ExecutionException, InterruptedException {
        // 模拟发送的消息
        int id = 6687421;
        MessageMock messageMock = new MessageMock(id,"artisanTestMessage-" + id);


        // 测试顺序消息 以 id 为key  (因为使用 String 的方式序列化 key ，所以需要将 id 转换成 String)
        return kafkaTemplate.send(TOPIC.TOPIC,String.valueOf(id) ,messageMock).get();
    }

    /**
     * 同步发送
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public SendResult sendMsgSync2() throws ExecutionException, InterruptedException {
        // 模拟发送的消息
        int id = 1255447;
        MessageMock messageMock = new MessageMock(id,"artisanTestMessage-" + id);


        // 测试顺序消息 以 id 为key  (因为使用 String 的方式序列化 key ，所以需要将 id 转换成 String)
        return kafkaTemplate.send(TOPIC.TOPIC,String.valueOf(id) ,messageMock).get();
    }

}
    