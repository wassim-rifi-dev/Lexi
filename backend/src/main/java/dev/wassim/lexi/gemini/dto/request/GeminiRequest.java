package dev.wassim.lexi.gemini.dto.request;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeminiRequest {
    private List<Content> contents;
}
