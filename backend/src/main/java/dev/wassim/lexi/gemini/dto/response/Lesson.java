package dev.wassim.lexi.gemini.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    private String word;

    private String sentence;

    @JsonProperty("correct_meaning")
    private String correctMeaning;

    @JsonProperty("wrong_meaning_1")
    private String wrongMeaning1;

    @JsonProperty("wrong_meaning_2")
    private String wrongMeaning2;

    @JsonProperty("wrong_meaning_3")
    private String wrongMeaning3;
}
