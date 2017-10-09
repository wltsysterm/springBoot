package com.neo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * created by 魏霖涛 on 2017/10/9 0009
 */
@Component
@ConfigurationProperties(prefix = "active")
public class ConfiProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
