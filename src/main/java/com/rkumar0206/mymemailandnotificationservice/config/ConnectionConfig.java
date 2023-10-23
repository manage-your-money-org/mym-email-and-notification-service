package com.rkumar0206.mymemailandnotificationservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "connection")
@Getter
@Setter
public class ConnectionConfig {

    private String appHostUrl;
    private Integer port;
}
