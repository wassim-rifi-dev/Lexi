package dev.wassim.lexi.gemini.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import dev.wassim.lexi.gemini.dto.request.GeminiRequest;
import dev.wassim.lexi.gemini.dto.response.GeminiApiResponse;
import dev.wassim.lexi.gemini.dto.response.GeminiResponse;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class GeminiClient {
    private final ObjectMapper objectMapper;

    private String key = "${GEMINI_API_KEY}";

    public GeminiResponse generateWords(GeminiRequest request) {
        GeminiApiResponse response = RestClient.create()
            .post()
            .uri(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=" + key
            )
            .body(request)
            .retrieve()
            .body(GeminiApiResponse.class);

        String innerJson = response
            .getCandidates()
            .get(0)
            .getContent()
            .getParts()
            .get(0)
            .getText();

        return objectMapper.readValue(innerJson, GeminiResponse.class);
    }
}