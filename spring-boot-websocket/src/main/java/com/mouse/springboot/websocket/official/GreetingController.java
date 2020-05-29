package com.mouse.springboot.websocket.official;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-21
 * @description
 */
@Controller
public class GreetingController {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greetings(HelloMessage helloMessage) throws Exception{
        Thread.sleep(1000);
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(helloMessage.getName())+"!");
    }

    /**
     * 定时推送消息
     */
//    @Scheduled(fixedRate = 1000)
    public void callback() {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/topic/callback", "定时推送消息时间: " + df.format(new Date()));
    }

}
