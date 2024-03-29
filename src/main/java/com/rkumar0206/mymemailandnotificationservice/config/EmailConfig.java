package com.rkumar0206.mymemailandnotificationservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {

    private String host;
    private String username;
    private String port;
}
