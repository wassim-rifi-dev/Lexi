package dev.wassim.lexi.gemini.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import dev.wassim.lexi.gemini.dto.request.GeminiRequest;
import dev.wassim.lexi.gemini.dto.response.GeminiApiResponse;

@Component
public class GeminiMapper {
    public GeminiApiResponse toGeminiResponse(String key , GeminiRequest request) {
        return RestClient.create()
                        .post()
                        .uri(
                            "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=" + key
                        )
                        .body(request)
                        .retrieve()
                        .body(GeminiApiResponse.class);
    }

    public String toGeminiResponseJson(GeminiApiResponse response) {
        return response.getCandidates()
                        .get(0)
                        .getContent()
                        .getParts()
                        .get(0)
                        .getText();
    }
}
