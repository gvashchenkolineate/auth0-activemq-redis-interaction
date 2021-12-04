package com.lineate.internal.idp.interaction.storage;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class InMemoryTokenStorage implements TokenStorage {
    private final Map<String, String> audienceToTokenMap;

    public InMemoryTokenStorage() {
        audienceToTokenMap = new ConcurrentHashMap<>();
    }

    @Override
    public void save(String audience, String token) {
        log.info("Save token for audience {}", audience);
        audienceToTokenMap.put(audience, token);
    }

    @Override
    public String get(String audience) {
        String token = audienceToTokenMap.get(audience);
        if (token == null) {
            log.info("There was no token stored for audience {}", audience);
        }
        return token;
    }
}
