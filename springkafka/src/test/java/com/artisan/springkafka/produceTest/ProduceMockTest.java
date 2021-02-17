package com.artisan.springkafka.produceTest;

import com.artisan.springkafka.SpringkafkaApplication;
import com.artisan.springkafka.producer.ArtisanProducerMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/17 22:40
 * @mark: show me the code , change the world
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringkafkaApplication.class)
public class ProduceMockTest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ArtisanProducerMock artisanProducerMock;

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        SendResult sendResult = artisanProducerMock.sendMsgSync();

        logger.info("testSyncSend Result =  topic:[{}] , partition:[{}], offset:[{}]",
                sendResult.getRecordMetadata().topic(),
                sendResult.getRecordMetadata().partition(),
                sendResult.getRecordMetadata().offset());

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
    