/**
 * Author: Roshan Adhikari
 * Package: com.dummyex.gatewayservice.config
 *
 * RateLimiterConfig class is responsible for configuring rate limiting settings using RedisRateLimiter
 * and defining a KeyResolver bean for rate limiting based on user keys.
 */
package com.dummyex.gatewayservice.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    /**
     * Defines a KeyResolver bean for rate limiting based on user keys.
     *
     * @return KeyResolver instance
     */
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just("1"); // Simplified for demonstration
    }

    /**
     * Defines a RedisRateLimiter bean with a rate limit of 5 requests per second and a burst capacity of 7.
     *
     * @return RedisRateLimiter instance
     */
    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(5, 7); // 5 requests per second, 7 burst capacity
    }
}
