package dev.wassim.lexi.features.words.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wassim.lexi.domain.modal.Word;

public interface WordRepository extends JpaRepository<Word , Long> {
    
}
