package com.example.resilience4jdemo.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Feign {

    public static IFeignClient fallback = new IFeignClient() {
        @Override
        public String getGreeting() {
            return "failed, hello";
        }

        @Override
        public String createGreeting() {
            return "failed, create hello";
        }

        @Override
        public String getGreetingException() {
            return "exception";
        }
    };

    @Bean
    public IFeignClient get() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("backendName");
        RateLimiter rateLimiter = RateLimiter.ofDefaults("backendName");
        FeignDecorators decorators = FeignDecorators.builder()
//                .withRateLimiter(rateLimiter)
//                .withCircuitBreaker(circuitBreaker)
                .withFallback(fallback, Exception.class)
                .build();
        return Resilience4jFeign.builder(decorators).target(IFeignClient.class, "http://localhost:8099/");
    }

}
