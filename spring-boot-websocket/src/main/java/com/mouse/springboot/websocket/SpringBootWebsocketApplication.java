package com.mouse.springboot.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class SpringBootWebsocketApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootWebsocketApplication.class);

    /**
     * http://127.0.0.1:8080
     *
     * @param args
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(SpringBootWebsocketApplication.class, args);
        Instant end = Instant.now();

        Duration between = Duration.between(start, end);
        LOGGER.info("Application start successfully. Take [{}] seconds.", between.getSeconds());
    }

}
