package dev.wassim.lexi.gemini.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeminiResponse {
    private List<Lesson> lessons;
}
