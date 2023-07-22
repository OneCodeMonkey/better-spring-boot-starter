package com.liuyang1.betterspringbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * starter 定义启动时的配置项
 * 1.属性中如果有默认值，那么使用该starter时就不用显式指定该属性，可以直接使用
 */
@ConfigurationProperties(prefix = "liuyang1.redisson")
public class RedissonProperties {
    private String host = "localhost";

    private int port = 6379;

    private int timeout = 1000;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

}
