package dev.wassim.lexi.features.words.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wassim.lexi.common.constants.ApiPaths;
import dev.wassim.lexi.features.words.dto.response.WordResponse;
import dev.wassim.lexi.features.words.services.WordService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(ApiPaths.Api_Words)
@AllArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping("/today")
    public List<WordResponse> getTodayWords() {
        return wordService.getTodayWords();
    }
    
}
