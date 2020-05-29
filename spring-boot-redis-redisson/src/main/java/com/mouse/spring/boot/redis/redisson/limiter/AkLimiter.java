package com.mouse.spring.boot.redis.redisson.limiter;

import org.redisson.api.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
@Component
public class AkLimiter {

    @Resource
    private RedissonClient redissonClient;

    public boolean limit(String key,int period,int count){
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        boolean exists = rateLimiter.isExists();
        if (!exists){
            rateLimiter.trySetRate(RateType.OVERALL,count,period, RateIntervalUnit.SECONDS);
        }
        return rateLimiter.tryAcquire(1, TimeUnit.SECONDS);
    }

}
