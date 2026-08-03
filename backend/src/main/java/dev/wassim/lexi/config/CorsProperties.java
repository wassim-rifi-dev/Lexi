package dev.wassim.lexi.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("app.cors")
public class CorsProperties {
    private List<String> allowedOrigins;
}
