package com.cec.tv.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
@Data
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    private int timeout;



}
