package com.example.redisdelay.service;

import com.example.redisdelay.info.RedisDelayInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Component
public class RedisConsumer {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Scheduled(cron = "0/1 * * * * *")
    public void consumer() {
        long cur = System.currentTimeMillis();
        Set<Serializable> range = redisTemplate.opsForZSet().rangeByScore(RedisDelay.KEY, 0, cur);
        for (Serializable re : range) {
            RedisDelayInfoData delayInfoData = (RedisDelayInfoData)re;
            System.out.println(String.format("消费任务： %s, %s", delayInfoData.getMessage(), LocalDateTime.now()));
            redisTemplate.opsForZSet().remove(RedisDelay.KEY, re);
        }
    }
}
