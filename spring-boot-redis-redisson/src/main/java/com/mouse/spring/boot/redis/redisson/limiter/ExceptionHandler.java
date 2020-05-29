package com.mouse.spring.boot.redis.redisson.limiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
@RestControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(LimiterException.class)
    public void hand(LimiterException e) {
        LOGGER.error("msg:{}", e.getMessage());
    }

}
