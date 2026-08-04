package dev.wassim.lexi.gemini.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GeminiClient {
    private final RestClient geminiRestClient;

    @Value("${gemini.api.key}")
    private String key;
}
