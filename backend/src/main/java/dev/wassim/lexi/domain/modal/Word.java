package dev.wassim.lexi.domain.modal;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private String sentence;

    @Column(name = "correct_meaning")
    private String correctMeaning;

    @Column(name = "wrong_meaning_1")
    private String wrongMeaning1;

    @Column(name = "wrong_meaning_2")
    private String wrongMeaning2;

    @Column(name = "wrong_meaning_3")
    private String wrongMeaning3;

    private LocalDate day;

    @Builder.Default
    private boolean finished = false;
}
