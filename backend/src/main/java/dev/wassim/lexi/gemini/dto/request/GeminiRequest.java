package dev.wassim.lexi.gemini.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
@AllArgsConstructor
public class GeminiRequest {
    private List<Content> contents;
}
