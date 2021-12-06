package com.lineate.internal.idp.interaction.service1.service;

import com.lineate.internal.idp.interaction.service1.model.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
    private  static final String DESTINATION = "Auth0ActivemqRedisInteraction";
    private final JmsTemplate jmsTemplate;

    public void sendMessage(Message message) {
        jmsTemplate.convertAndSend(DESTINATION, message);
        log.info("Message sent: {}", message);
    }
}
