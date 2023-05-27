package com.example.JavaApp.Answer;

import jakarta.persistence.*;

@Entity
@Table(name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long questionId;
    @Column
    private String answerText;

    public Answer() {
    }

    public Answer(Long id, Long questionId, String answerText) {
        this.id = id;
        this.questionId = questionId;
        this.answerText = answerText;
    }

    public Answer(Long questionId, String answerText) {
        this.questionId = questionId;
        this.answerText = answerText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", answerText='" + answerText + '\'' +
                '}';
    }
}
