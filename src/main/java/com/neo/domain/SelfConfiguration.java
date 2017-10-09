package com.neo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
@Component
@ConfigurationProperties(prefix ="",locations = "classpath:selfConfiguration.properties")
public class SelfConfiguration {
//    @Value("${name}")//这种方式取不到
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
