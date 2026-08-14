package dev.wassim.lexi.features.words.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.wassim.lexi.domain.modal.Word;
import dev.wassim.lexi.features.words.dto.response.WordResponse;
import dev.wassim.lexi.features.words.mapper.WordMapper;
import dev.wassim.lexi.features.words.repositories.WordRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WordService {
    private final WordRepository wordRepository;
    private final WordMapper wordMapper;

    public List<WordResponse> getTodayWords() {
        LocalDate day = wordRepository.getMaxDate();

        List<Word> todayWords = wordRepository.findByDay(day);

        return todayWords.stream()
                    .map(wordMapper::toWordResponse)
                    .toList();
    }
}
