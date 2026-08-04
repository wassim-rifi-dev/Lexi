package dev.wassim.lexi.gemini.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import dev.wassim.lexi.gemini.dto.request.GeminiRequest;
import dev.wassim.lexi.gemini.dto.response.GeminiResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GeminiClient {
    private final RestClient geminiRestClient;

    @Value("${gemini.api.key}")
    private String key;

    public GeminiResponse generateWords(GeminiRequest request) {
        return geminiRestClient.post()
                            .uri(uriBuilder -> uriBuilder
                                .path("/gemini-2.5-flash:generateContent")
                                .queryParam("key", key)
                                .build()
                            )
                            .body(request)
                            .retrieve()
                            .body(GeminiResponse.class);
    }
}
