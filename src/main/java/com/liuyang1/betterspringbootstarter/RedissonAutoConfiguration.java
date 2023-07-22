package com.liuyang1.betterspringbootstarter;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 条件装配：只有当我们的 classpath 目录下有 Redisson.class 我们才自动装配 RedissonClient bean
 *
 * @ConditionalOnClass(Redisson.class)
 */
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {
    private static final String PREFIX = "redis://";

    @Bean
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        // redis 单机模式
        config.useSingleServer().setAddress(PREFIX + redissonProperties.getHost() + ":" + redissonProperties.getPort())
                .setConnectTimeout(redissonProperties.getTimeout());

        return Redisson.create(config);
    }
}
