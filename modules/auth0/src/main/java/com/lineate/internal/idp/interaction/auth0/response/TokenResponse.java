package com.lineate.internal.idp.interaction.auth0.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TokenResponse {
    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("expires_in")
    int expiresIn;
    @JsonProperty("token_type")
    String tokenType;
}
