package com.lineate.internal.idp.interaction.storage;

public interface TokenStorage {
    void save(String audience, String token);
    String get(String audience);
}
