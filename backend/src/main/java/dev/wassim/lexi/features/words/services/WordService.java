package dev.wassim.lexi.features.words.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.wassim.lexi.domain.modal.Word;
import dev.wassim.lexi.features.words.dto.response.WordResponse;
import dev.wassim.lexi.features.words.mapper.WordMapper;
import dev.wassim.lexi.features.words.repositories.WordRepository;
import dev.wassim.lexi.gemini.services.GeminiService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WordService {
    private final WordRepository wordRepository;
    private final WordMapper wordMapper;
    private final GeminiService geminiService;

    public List<WordResponse> getTodayWords() {
        LocalDate day = wordRepository.getMaxDate();

        if (day == null) {
            geminiService.generateWords();

            day = wordRepository.getMaxDate();
        }

        boolean isToday = day.equals(LocalDate.now());

        List<Word> words = wordRepository.findByDayAndFinished(day, false);

        if (isToday && words.isEmpty()) {
            return List.of();
        }

        
        if (!isToday && words.isEmpty()) {
            geminiService.generateWords();

            day = wordRepository.getMaxDate();
            words = wordRepository.findByDayAndFinished(day, false);
        }

        return words.stream()
                    .map(wordMapper::toWordResponse)
                    .toList();
    }
}
