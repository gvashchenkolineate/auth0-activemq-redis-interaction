package com.lineate.internal.idp.interaction.service1.service;

import com.lineate.internal.idp.interaction.auth0.Auth0TokenRetriever;
import com.lineate.internal.idp.interaction.auth0.request.TokenRequest;
import com.lineate.internal.idp.interaction.auth0.response.TokenResponse;
import com.lineate.internal.idp.interaction.service1.security.Auth0Properties;
import com.lineate.internal.idp.interaction.service1.security.IssuerProperties;
import com.lineate.internal.idp.interaction.storage.TokenStorage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class TokenService {
    private Auth0TokenRetriever tokenRetriever;
    private Auth0Properties auth0Properties;
    private IssuerProperties issuerProperties;
    private TokenStorage tokenStorage;


    public TokenResponse retrieveToken() {
        TokenRequest request = TokenRequest.builder()
                .clientId(auth0Properties.getClientId())
                .clientSecret(auth0Properties.getClientSecret())
                .audience(auth0Properties.getAudience().getService1())
                .build();
        TokenResponse response = tokenRetriever.requestToken(issuerProperties.getIssuerUri(), request);

        tokenStorage.save(auth0Properties.getAudience().getService1(), response.getAccessToken());

        return response;
    }

    public String getToken() {
        return tokenStorage.get(auth0Properties.getAudience().getService1());
    }
}
