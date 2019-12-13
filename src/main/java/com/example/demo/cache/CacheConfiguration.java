package com.example.demo.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    public static final String IN_MEMORY_DISCOUNT_CACHE = "discount-cache";
    public static final String REDIS_DISCOUNT_CACHE = "discount-cache-redis";

    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();
        final Collection<Cache> caches = Arrays.asList(
                caffeineCacheBuilder(IN_MEMORY_DISCOUNT_CACHE, 60, ticker),
                caffeineCacheBuilder(REDIS_DISCOUNT_CACHE, 300, ticker)
        );
        cacheManager.setCaches(caches);
        return cacheManager;
    }


    private Cache caffeineCacheBuilder(final String name, long expireTime, Ticker ticker) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                .expireAfterWrite(expireTime, TimeUnit.SECONDS)
                .ticker(ticker)
                .build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }

}
