package com.artisan.springkafka.producer;

import com.artisan.springkafka.constants.TOPIC;
import com.artisan.springkafka.domain.MessageMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate ;


    public String testTransaction(Runnable runnable){
        return kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback<Object, Object, String>() {

            @Override
            public String doInOperations(KafkaOperations<Object, Object> operations)  throws  RuntimeException {

                for (int i = 1; i <= 10; i++) {
                    // 用于测试  消息是否在同一个事务中
                    if (i   == 7 ) {
                        throw new RuntimeException("MOCK ERROR , TEST Tranasction");
                    }

                    // 模拟发送的消息
                    Integer id = new Random().nextInt(100);
                    MessageMock messageMock = new MessageMock(id,"messageSendByAsync-" + id);
                    SendResult<Object, Object> sendResult = null;
                    try {
                        sendResult = operations.send(TOPIC.TOPIC, messageMock).get();
                    }  catch ( Exception e) {
                        logger.error("Error {}", e);
                    }
                    logger.info( i+ "-[doInOperations][发送数据：[{}] 发送结果：[{}]]", messageMock, sendResult);
                    // 本地业务逻辑...
                    runnable.run();
                }

                // 返回结果
                return "OJ8K";
            }
        });
    }

}
    