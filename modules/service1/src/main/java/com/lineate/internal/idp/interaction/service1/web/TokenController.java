package com.lineate.internal.idp.interaction.service1.web;

import com.lineate.internal.idp.interaction.service1.model.Message;
import com.lineate.internal.idp.interaction.service1.service.TokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/token")
public class TokenController {
    private TokenService tokenService;

    @GetMapping(value = "update")
    public Message retrieveNewToken() {
        var token = tokenService.retrieveToken();
        return new Message("New token retrieved: " + token.toString());
    }

    @GetMapping(value = "get")
    public Message getToken() {
        var token = tokenService.getToken();
        return new Message("Token is: " + token);
    }


}
