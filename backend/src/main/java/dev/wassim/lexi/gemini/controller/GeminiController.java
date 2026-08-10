package dev.wassim.lexi.gemini.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.wassim.lexi.gemini.services.GeminiService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
public class GeminiController {
    private final GeminiService geminiService;

    @GetMapping("/")
    public void printResponse() {
        geminiService.generateWords();
    }
    
}
