package com.example.jms.sfgjms.sender;


import com.example.jms.sfgjms.config.JmsConfig;
import com.example.jms.sfgjms.model.HelloWorldMessage;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I am a sending message");

        HelloWorldMessage message=HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello world message from sender")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,message);

        System.out.println("message sent");
    }
}
