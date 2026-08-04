package dev.wassim.lexi.gemini.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.wassim.lexi.config.GeminiConfig;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeminiService {
    private final GeminiConfig geminiConfig;

    @Value("${gemini.api.key}")
    private String key;
}
