package com.lineate.internal.idp.interaction.service1.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "auth0")
public class Auth0Properties {
    String clientId;
    String clientSecret;
    Audience audience;

    @Getter
    @Setter
    public static class Audience {
        String service1;
        String service2;
    }
}
