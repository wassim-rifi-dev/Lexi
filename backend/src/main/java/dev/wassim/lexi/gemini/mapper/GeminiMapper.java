package dev.wassim.lexi.gemini.mapper;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import dev.wassim.lexi.domain.modal.Word;
import dev.wassim.lexi.gemini.dto.request.Content;
import dev.wassim.lexi.gemini.dto.request.GeminiRequest;
import dev.wassim.lexi.gemini.dto.request.Part;
import dev.wassim.lexi.gemini.dto.response.GeminiApiResponse;
import dev.wassim.lexi.gemini.dto.response.Lesson;

@Component
public class GeminiMapper {
        public GeminiApiResponse toGeminiResponse(String key , GeminiRequest request) {
                return RestClient.create()
                                .post()
                                .uri(
                                        "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=" + key
                                )
                                .body(request)
                                .retrieve()
                                .body(GeminiApiResponse.class);
        }

        public String toGeminiResponseJson(GeminiApiResponse response) {
                return response.getCandidates()
                                .get(0)
                                .getContent()
                                .getParts()
                                .get(0)
                                .getText();
        }

        public GeminiRequest toGeminiRequest(String prompt) {
                return GeminiRequest.builder()
                        .contents(
                                List.of(
                                        Content.builder()
                                                .parts(
                                                        List.of(
                                                                Part.builder()
                                                                        .text(prompt)
                                                                        .build()
                                                        )
                                                )
                                                .build()
                                )
                        )
                        .build();
        }

        public Word buildWord(Lesson lesson) {
                return Word.builder()
                        .word(lesson.getWord())
                        .sentence(lesson.getSentence())
                        .correctMeaning(lesson.getCorrectMeaning())
                        .wrongMeaning1(lesson.getWrongMeaning1())
                        .wrongMeaning2(lesson.getWrongMeaning2())
                        .wrongMeaning3(lesson.getWrongMeaning3())
                        .day(LocalDate.now())
                        .build();
        }
}
