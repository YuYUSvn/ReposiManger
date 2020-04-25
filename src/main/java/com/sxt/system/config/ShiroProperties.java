package com.sxt.system.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {
    private String hashAlgorithmName="md5";

    private Integer hashIterations=2;

    private String loginUrl;

    private String unauthorizedUrl;

    private String [] anonUrls;

    private String logoutUrl;

    private String [] authcUrls;

}
