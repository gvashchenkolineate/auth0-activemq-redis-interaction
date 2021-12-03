package com.lineate.internal.idp.interaction.service1.web;

import com.lineate.internal.idp.interaction.service1.model.Message;
import com.lineate.internal.idp.interaction.service1.service.RequestsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/requests")
public class RequestsController {
    private RequestsService requestsService;

    @GetMapping(value = "/token/retrieve")
    public Message retrieveNewToken() {
        var token = requestsService.retrieveToken();
        return new Message("New token retrieved: " + token.toString());
    }
}
