package com.lineate.internal.idp.interaction.service1.config;

import com.lineate.internal.idp.interaction.config.RedisProperties;
import com.lineate.internal.idp.interaction.storage.InMemoryTokenStorage;
import com.lineate.internal.idp.interaction.storage.RedisTokenStorage;
import com.lineate.internal.idp.interaction.storage.TokenStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    @ConditionalOnProperty(value = "redis.enabled", havingValue = "true")
    public TokenStorage redisTokenStorage(RedisProperties redisProperties) {
        return new RedisTokenStorage(redisProperties);
    }

    @Bean
    @ConditionalOnMissingBean(TokenStorage.class)
    public TokenStorage inMemoryTokenStorage() {
        return new InMemoryTokenStorage();
    }
}
