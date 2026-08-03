package dev.wassim.lexi.features.words.mapper;

import org.springframework.stereotype.Component;

import dev.wassim.lexi.domain.modal.Word;
import dev.wassim.lexi.features.words.dto.response.WordResponse;

@Component
public class WordMapper {
    public WordResponse toWordResponse(Word word) {
        return WordResponse.builder()
                        .word(word.getWord())
                        .sentence(word.getSentence())
                        .correctMeaning(word.getCorrectMeaning())
                        .wrongMeaning1(word.getWrongMeaning1())
                        .wrongMeaning2(word.getWrongMeaning2())
                        .wrongMeaning3(word.getWrongMeaning3())
                        .build();
    }
}
