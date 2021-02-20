package com.artisan.springkafka.produceTest;

import com.artisan.springkafka.SpringkafkaApplication;
import com.artisan.springkafka.constants.TOPIC;
import com.artisan.springkafka.domain.MessageMock;
import com.artisan.springkafka.producer.ArtisanProducerMock;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author 小工匠
 *  * @version 1.0
 * @description: TODO
 * @date 2021/2/17 22:40
 * @mark: show me the code , change the world
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringkafkaApplication.class)
public class ProduceMockTest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    ArtisanProducerMock artisanProducerMock;


    @Test
    @Transactional
    public void testTransactionalAnnotation() throws InterruptedException, ExecutionException {

        artisanProducerMock.testTransactionByAnno();

//        throw new RuntimeException("MOCK FAIL ,TEST TRANSACTION");

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }


    @Test
    public void testT(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.126.140:9092");
        props.put("transactional.id", "my-transactional-id");
        Producer<String, String> producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());

        producer.initTransactions();

        try {
            producer.beginTransaction();
            for (int i = 0; i < 100; i++)
                producer.send(new ProducerRecord<>("my-topic", Integer.toString(i), Integer.toString(i)));
            producer.commitTransaction();
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            // We can't recover from these exceptions, so our only option is to close the producer and exit.
            producer.close();
        } catch (KafkaException e) {
            // For all other exceptions, just abort the transaction and try again.
            producer.abortTransaction();
        }
        producer.close();
    }

    @Test
    public void testT2(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.126.140:9092");
        props.put("transactional.id", "my-transactional-id");
        Producer<String, String> producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());

        producer.initTransactions();

        try {
            producer.beginTransaction();
            for (int i = 0; i < 100; i++){
                producer.send(new ProducerRecord<>("my-topic2", Integer.toString(i), Integer.toString(i)));
                if (i == 50) {
                    throw new RuntimeException("MOCK Exception");
                }
            }

            producer.commitTransaction();
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            // We can't recover from these exceptions, so our only option is to close the producer and exit.
            producer.close();
        } catch (KafkaException e) {
            // For all other exceptions, just abort the transaction and try again.
            producer.abortTransaction();
        }
        producer.close();
    }

}
    