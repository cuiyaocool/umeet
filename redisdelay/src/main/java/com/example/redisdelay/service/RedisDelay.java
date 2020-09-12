package com.example.redisdelay.service;

import com.example.redisdelay.info.RedisDelayInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Service
public class RedisDelay {
    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    public static final String KEY = "delaymq";

    @PostConstruct
    public void init() {
        RedisDelayInfoData r1 = new RedisDelayInfoData(1, "第1个任务序号");
        redisTemplate.opsForZSet().add(KEY, r1, System.currentTimeMillis() + 5000);
        RedisDelayInfoData r2 = new RedisDelayInfoData(2, "第2个任务序号");
        redisTemplate.opsForZSet().add(KEY, r2, System.currentTimeMillis() + 2000);
        RedisDelayInfoData r3 = new RedisDelayInfoData(3, "第3个任务序号");
        redisTemplate.opsForZSet().add(KEY, r3, System.currentTimeMillis() + 3000);
        RedisDelayInfoData r4 = new RedisDelayInfoData(4, "第4个任务序号");
        redisTemplate.opsForZSet().add(KEY, r4, System.currentTimeMillis() + 5000);
        RedisDelayInfoData r5 = new RedisDelayInfoData(5, "第5个任务序号");
        redisTemplate.opsForZSet().add(KEY, r5, System.currentTimeMillis() + 10000);
        RedisDelayInfoData r6 = new RedisDelayInfoData(6, "第6个任务序号");
        redisTemplate.opsForZSet().add(KEY, r6, System.currentTimeMillis() + 7000);
    }

}
