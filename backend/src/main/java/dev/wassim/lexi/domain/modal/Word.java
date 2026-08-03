package dev.wassim.lexi.domain.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
}
