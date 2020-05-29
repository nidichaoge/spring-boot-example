package com.mouse.spring.boot.redis.redisson.limiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/11
 * @description
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(){

        return "ok";
    }

    @Limit(key = "mouse:limiter")
    @GetMapping("/limiter")
    public String limiter(){
       LOGGER.info("limiter");
        return "ok";
    }

    @Limit(key = "mouse:limiter",limitType = LimitType.IP,period = 10,count = 20)
    @GetMapping("/limiter2")
    public String limiterWithIP(){
        LOGGER.info("limiterWithIP");
        return "ok";
    }

    @Limit(key = "mouse:limiter3",period = 10,count = 20)
    @GetMapping("/limiter")
    public String limiter3(){
        LOGGER.info("limiter3");
        return "ok";
    }

    @Limit(key = "mouse:limiter4",period = 10,count = 30)
    @GetMapping("/limiter")
    public String limiter4(){
        LOGGER.info("limiter4");
        return "ok";
    }

}
