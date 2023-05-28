package com.example.JavaApp.Question;

import jakarta.persistence.*;

@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long subjectId;
    @Column
    private String questionText;
    @Column
    private Long questionDifficulty;

    public Question() {
    }

    public Question(Long id, Long subjectId, String questionText, Long questionDifficulty) {
        this.id = id;
        this.subjectId = subjectId;
        this.questionText = questionText;
        this.questionDifficulty = questionDifficulty;
    }

    public Question(Long subjectId, String questionText, Long questionDifficulty) {
        this.subjectId = subjectId;
        this.questionText = questionText;
        this.questionDifficulty = questionDifficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(Long questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", questionText='" + questionText + '\'' +
                ", questionDifficulty=" + questionDifficulty +
                '}';
    }
}
