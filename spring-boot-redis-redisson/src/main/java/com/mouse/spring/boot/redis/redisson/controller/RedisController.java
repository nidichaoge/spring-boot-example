package com.mouse.spring.boot.redis.redisson.controller;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-04-09
 * @description
 */
@RestController
public class RedisController {

    @Resource
    private RedissonClient redissonClient;

    public void limit(){

    }












//
    @GetMapping("/take")
    public String take(){
        RBlockingQueue<Long> test = redissonClient.getBlockingQueue("test");
        try {
            Long take = test.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @PostMapping("/put")
    public String put(){
        RBlockingQueue<Long> test = redissonClient.getBlockingQueue("test");
        long i=0;
        while (i<=100_000){
            try {
                test.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

        return "ok";
    }

}
