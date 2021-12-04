package com.lineate.internal.idp.interaction.auth0;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lineate.internal.idp.interaction.auth0.request.TokenRequest;
import com.lineate.internal.idp.interaction.auth0.response.TokenResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@AllArgsConstructor
@Service
public class Auth0TokenRetriever {
    private static final String TOKEN_ENDPOINT = "oauth/token";

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;


    public TokenResponse requestToken(String issuerUri, TokenRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TokenRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(issuerUri + TOKEN_ENDPOINT , HttpMethod.POST, entity, JsonNode.class);

        // TODO throw exceptions

        log.info("Token successfully retrieved: {}", response);
        return objectMapper.convertValue(response.getBody(), new TypeReference<>() {
        });
    }
}
