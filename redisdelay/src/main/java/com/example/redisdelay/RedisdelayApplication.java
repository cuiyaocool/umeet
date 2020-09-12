package com.example.redisdelay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RedisdelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisdelayApplication.class, args);
    }

}
