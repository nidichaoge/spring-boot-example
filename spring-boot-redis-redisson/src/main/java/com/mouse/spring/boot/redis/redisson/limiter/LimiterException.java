package com.mouse.spring.boot.redis.redisson.limiter;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
public class LimiterException extends RuntimeException {

    public LimiterException(String message){
        super(message);
    }
}
