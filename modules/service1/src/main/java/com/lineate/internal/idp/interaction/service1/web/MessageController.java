package com.lineate.internal.idp.interaction.service1.web;

import com.lineate.internal.idp.interaction.service1.model.Message;
import com.lineate.internal.idp.interaction.service1.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/message")
public class MessageController {
    private final MessageService messageService;

    @PostMapping(value = "send")
    public Message send(Message income) {
        log.info("Message received for sending to ActiveMQ: {}", income);
        messageService.sendMessage(income);
        return new Message("Message sent");
    }

    @GetMapping(value = "read")
    public Message read() {
        log.info("Read message from ActiveMQ");
        return new Message("That");
    }
}
