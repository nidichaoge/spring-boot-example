package com.mouse.springboot.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBootInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInterceptorApplication.class, args);
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("");
    }

}
