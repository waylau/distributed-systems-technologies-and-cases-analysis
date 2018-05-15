/**
 * Welcome to https://waylau.com
 */
package com.waylau.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Jedis Configuration.
 * 
 * @since 1.0.0 2018年5月15日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Configuration
public class JedisConfig {

    private static JedisPool jedisPool;

    @Bean
    public Jedis getBuild() {
        jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}