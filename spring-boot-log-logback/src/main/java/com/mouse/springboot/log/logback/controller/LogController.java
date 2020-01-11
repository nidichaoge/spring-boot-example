package com.mouse.springboot.log.logback.controller;

import com.mouse.springboot.log.logback.log.LazyLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-11
 * @description
 */
@RestController
@RequestMapping("/log")
public class LogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/test")
    public String test() {
        LOGGER.trace("hello trace");
        LOGGER.debug("hello debug");
        LOGGER.info("hello info");
        LOGGER.warn("hello warn");
        LOGGER.error("hello error");
        return "ok";
    }

    /**
     * 当该日志级别低于可以打印的日志级别时,日志不会打印出来,但是日志里的参数会进行方法调用,有两种解决方法
     * 1 打印前判断日志级别
     * 2 惰性日志
     *
     * @return
     */
    @GetMapping("/test2")
    public String test2() {
        LOGGER.trace("hello1, function:{}.", function());

        //1 打印前判断日志级别
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("hello2, function:{}.", function());
        }

        //2 惰性日志
        LOGGER.trace("hello3, function:{}.", LazyLogger.lazy(this::function));

        return "ok";
    }

    private String function() {
        System.out.println("function is used");
        return "function";
    }

}
