package com.lineate.internal.idp.interaction.storage;

import com.lineate.internal.idp.interaction.config.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class RedisTokenStorage implements TokenStorage {
    private Jedis jedis;

    public RedisTokenStorage(RedisProperties redisProperties) {
        jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }

    @Override
    public void save(String audience, String token) {
        log.info("Save token for audience {} into Redis", audience);
        jedis.set(audience, token);
    }

    @Override
    public String get(String audience) {
        String token = jedis.get(audience);
        if (token == null) {
            log.info("There was no token stored in Redis for audience {}", audience);
        }
        return token;
    }
}
