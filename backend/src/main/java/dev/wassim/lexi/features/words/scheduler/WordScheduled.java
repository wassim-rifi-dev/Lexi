package dev.wassim.lexi.features.words.scheduler;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.wassim.lexi.domain.modal.Word;
import dev.wassim.lexi.features.words.repositories.WordRepository;
import dev.wassim.lexi.gemini.services.GeminiService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class WordScheduled {
    private final GeminiService geminiService;
    private final WordRepository wordRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void createWords() {
        LocalDate day = wordRepository.getMaxDate();

        if (day == null) {
            geminiService.generateWords();
            return;
        }

        boolean isToday = day.equals(LocalDate.now());

        List<Word> words = wordRepository.findByDayAndFinished(day, false);

        if (!isToday && words.isEmpty()) {
            geminiService.generateWords();
        }
    }
}
