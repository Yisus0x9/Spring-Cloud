package com.yisus.yisusg_live.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "yisus.application")
public class Yisus09Config {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String applicationName) {
        this.name = applicationName;
    }
}
