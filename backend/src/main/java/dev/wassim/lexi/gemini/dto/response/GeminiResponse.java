package dev.wassim.lexi.gemini.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeminiResponse {
    private List<Lesson> lessons;
}
