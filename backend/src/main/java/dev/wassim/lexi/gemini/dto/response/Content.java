package dev.wassim.lexi.gemini.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class Content {
    private List<Part> parts;
}
