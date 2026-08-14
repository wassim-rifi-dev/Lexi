package dev.wassim.lexi.features.words.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WordResponse {
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
