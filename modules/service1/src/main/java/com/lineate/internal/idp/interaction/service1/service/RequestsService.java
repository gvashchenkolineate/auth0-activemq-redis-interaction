package com.lineate.internal.idp.interaction.service1.service;

import com.lineate.internal.idp.interaction.auth0.Auth0TokenRetriever;
import com.lineate.internal.idp.interaction.auth0.request.TokenRequest;
import com.lineate.internal.idp.interaction.auth0.response.TokenResponse;
import com.lineate.internal.idp.interaction.service1.security.Auth0Properties;
import com.lineate.internal.idp.interaction.service1.security.IssuerProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RequestsService {
    private Auth0TokenRetriever tokenRetriever;
    private Auth0Properties auth0Properties;
    private IssuerProperties issuerProperties;


    public TokenResponse retrieveToken() {
        TokenRequest request = TokenRequest.builder()
                .clientId(auth0Properties.getClientId())
                .clientSecret(auth0Properties.getClientSecret())
                .audience(auth0Properties.getAudience().getService1())
                .build();
        return tokenRetriever.requestToken(issuerProperties.getIssuerUri(), request);
    }
}
