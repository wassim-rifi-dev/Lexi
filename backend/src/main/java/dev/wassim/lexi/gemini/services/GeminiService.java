package dev.wassim.lexi.gemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.wassim.lexi.domain.modal.Word;
import dev.wassim.lexi.features.words.repositories.WordRepository;
import dev.wassim.lexi.gemini.client.GeminiClient;
import dev.wassim.lexi.gemini.dto.request.GeminiRequest;
import dev.wassim.lexi.gemini.dto.response.GeminiResponse;
import dev.wassim.lexi.gemini.mapper.GeminiMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeminiService {
    private final GeminiClient geminiClient;
    private final GeminiMapper geminiMapper;
    private final WordRepository wordRepository;

    private static final String prompt = """
            You are an English vocabulary generator for an AI-powered English learning application.

            Your task is to generate English vocabulary words with one correct Arabic meaning and three plausible but incorrect Arabic meanings.

            ## Rules

            * Return **ONLY valid JSON**.
            * Do **NOT** include Markdown.
            * Do **NOT** wrap the JSON inside `json`.
            * Do **NOT** add explanations or comments.
            * All wrong meanings must be realistic and belong to the same category or difficulty level as the correct meaning.
            * The wrong meanings must not be identical to the correct meaning.
            * The English word should be appropriate for beginner to intermediate English learners (A1–B1).

            ## JSON format

            {
                "lessons": [
                    {
                        "word": "Hello",
                        "sentence": "Hello in my new house"
                        "correct_meaning": "مرحبا",
                        "wrong_meaning_1": "وداعا",
                        "wrong_meaning_2": "شكرا",
                        "wrong_meaning_3": "من فضلك"
                    }
                ]
            }

            Generate **5** vocabulary words following exactly this JSON structure.

            Return ONLY the JSON array.
            """;

    @Value("${gemini.api.key}")
    private String key;

    public void generateWords() {
        GeminiRequest request = geminiMapper.toGeminiRequest(prompt);

        GeminiResponse response = geminiClient.generateWords(request);

        List<Word> words = response.getLessons()
                            .stream()
                            .map(geminiMapper::buildWord)
                            .toList();

        wordRepository.saveAll(words);
    }
}
