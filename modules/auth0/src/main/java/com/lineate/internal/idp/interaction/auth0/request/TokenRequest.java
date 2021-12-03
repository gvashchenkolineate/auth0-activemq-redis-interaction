package com.lineate.internal.idp.interaction.auth0.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TokenRequest {
    @JsonProperty("client_id")
    String clientId;
    @JsonProperty("client_secret")
    String clientSecret;
    String audience;
    @JsonProperty("grant_type")
    String grantType = "client_credentials";
}
