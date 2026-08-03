package dev.wassim.lexi.features.words.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wassim.lexi.domain.modal.Word;
import java.time.LocalDate;


public interface WordRepository extends JpaRepository<Word , Long> {
    List<Word> findByDay(LocalDate day);
}
