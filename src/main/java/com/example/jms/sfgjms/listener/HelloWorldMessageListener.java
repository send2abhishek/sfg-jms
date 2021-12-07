package com.example.jms.sfgjms.listener;


import com.example.jms.sfgjms.config.JmsConfig;
import com.example.jms.sfgjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloWorldMessageListener {

    // listen to queue and get the message
    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("Got the message");
        System.out.println(helloWorldMessage);

    }
}
