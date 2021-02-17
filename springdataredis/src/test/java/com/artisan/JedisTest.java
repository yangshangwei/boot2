package com.artisan;



import com.artisan.domain.Artisan;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/16 20:56
 * @mark: show me the code , change the world
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testStringSetKey() {
        // set
        stringRedisTemplate.opsForValue().set("artisan", "good1");
        // get
        String artisan = stringRedisTemplate.opsForValue().get("artisan");
        System.out.println(artisan);
    }


    @Test
    public void testJacksonSerializer() {
        Artisan artisan  = new Artisan();
        artisan.setName("小工匠");
        artisan.setId(100);
        artisan.setSex("Male");
        // set
        redisTemplate.opsForValue().set("artisan", artisan);
    }

}
    