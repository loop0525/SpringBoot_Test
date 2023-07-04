package com.loop.compose_redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ComposeRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet(){
        redisTemplate.boundValueOps("loop").set("loop0525.top"); //SET key value
    }
    @Test
    public void testGet(){
        Object loop = redisTemplate.boundValueOps("loop").get(); //GET key
        System.out.println(loop);
    }

}
