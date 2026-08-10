package dev.wassim.lexi.gemini.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
@Data
@AllArgsConstructor
public class Content {
    private List<Part> parts;
}
