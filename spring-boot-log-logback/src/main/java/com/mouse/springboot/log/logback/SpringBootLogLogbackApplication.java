package com.mouse.springboot.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mouse
 * @description log-logback
 * logback-dev其实是spring的控制台默认配置文件 1 dev环境, 日志输出到控制台, 级别为debug, 希望输出更多地调试信息
 * logback-test其实是spring的文件默认配置文件
 * logback-prod生产可用 增加了异步输出日志     2 prod环境, 日志把info日志(info级别以上的所有日志)和error日志(仅包含error日志)分开输出
 * <p>
 * TODO
 * 必须配置好所有的logback xml文件, 否则会出现一些莫名其妙的问题
 * logback的加载顺序?
 */
@SpringBootApplication
public class SpringBootLogLogbackApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLogLogbackApplication.class);

    /**
     * springboot的默认logback配置路径及文件:
     * org.springframework.boot.logging.logback
     * base.xml
     * defaults.xml
     * console-appender.xml
     * file-appender.xml
     * <p>
     * logback中一共有5种有效级别，分别是TRACE、DEBUG、INFO、WARN、ERROR，优先级依次从低到高
     * slf4j是一个门面接口,其实现是logback,trace<debug<info<warn<error,默认打印级别是debug,所以trace不会打印出来
     *
     * @param args
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(SpringBootLogLogbackApplication.class, args);
        Instant end = Instant.now();

        Duration between = Duration.between(start, end);
        LOGGER.info("Application started successfully. Take [{}] seconds.", between.getSeconds());
    }

    /**
     * 答案是 100 remove()方法的参数是对象，存入的是Short类型，删除的i-1已经成了Integer类型，故无法删除
     * 答案是 3.0 发生了类型转换
     */
//	public static void main(String[] args) {
//		Set<Short> shortSet = new HashSet<Short>();
//		for (short i = 0; i < 100; i++) {
//			shortSet.add(i);
//			shortSet.remove(i - 1);
//		}
//		System.out.println(shortSet.size());
//
//		Object i = 1 == 1 ? new Integer(3) : new Float(1);
//		System.out.println(i);
//
//	}

}
