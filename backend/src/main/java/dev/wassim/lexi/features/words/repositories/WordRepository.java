package dev.wassim.lexi.features.words.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.wassim.lexi.domain.modal.Word;
import java.time.LocalDate;


public interface WordRepository extends JpaRepository<Word , Long> {
    @Query("SELECT MAX(w.day) FROM Word w")
    Optional<LocalDate> getMaxDate();

    List<Word> findByDay(LocalDate day);

    boolean existsByDay(LocalDate day);
}
