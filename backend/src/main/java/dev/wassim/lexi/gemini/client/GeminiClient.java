package dev.wassim.lexi.gemini.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dev.wassim.lexi.gemini.dto.request.GeminiRequest;
import dev.wassim.lexi.gemini.dto.response.GeminiApiResponse;
import dev.wassim.lexi.gemini.dto.response.GeminiResponse;
import dev.wassim.lexi.gemini.mapper.GeminiMapper;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class GeminiClient {
    private final ObjectMapper objectMapper;
    private final GeminiMapper geminiMapper;

    @Value("${gemini.api.key}")
    private String key;

    public GeminiResponse generateWords(GeminiRequest request) {
        GeminiApiResponse response = geminiMapper.toGeminiResponse(key, request);

        String innerJson = geminiMapper.toGeminiResponseJson(response);

        return objectMapper.readValue(innerJson, GeminiResponse.class);
    }
}