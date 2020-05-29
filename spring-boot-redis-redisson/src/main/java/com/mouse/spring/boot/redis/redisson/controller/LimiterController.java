package com.mouse.spring.boot.redis.redisson.controller;

import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
@RestController
public class LimiterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LimiterController.class);

    @Resource
    private RedissonClient redissonClient;

    @PostMapping("/create")
    public void limit(@RequestParam String name){
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(name);
        rateLimiter.trySetRate(RateType.OVERALL,10,1, RateIntervalUnit.SECONDS);
    }

    @GetMapping("/test")
    public String test(){
        LOGGER.info("test");
        return "ok";
    }

    @GetMapping("/test2")
    public String test2(){
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("mouse:test:limiter");
        rateLimiter.acquire();
        LOGGER.info("test2");
        return "ok";
    }
}
