package com.example.jms.sfgjms.listener;


import com.example.jms.sfgjms.config.JmsConfig;
import com.example.jms.sfgjms.model.HelloWorldMessage;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@AllArgsConstructor
@Component
public class HelloWorldMessageListener {

    private final JmsTemplate jmsTemplate;
    // listen to queue and get the message
    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("Got the message");
        System.out.println(helloWorldMessage);

    }

    // listen to queue and get the message
    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        HelloWorldMessage payloadMessage = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("world")
                .build();
        jmsTemplate.convertAndSend(message.getJMSReplyTo(),payloadMessage );

    }
}
