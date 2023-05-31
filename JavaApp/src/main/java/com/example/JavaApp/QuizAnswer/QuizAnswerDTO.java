package com.example.JavaApp.QuizAnswer;

import com.example.JavaApp.QuizQuestion.QuizQuestion;

public class QuizAnswerDTO {
    private Long answerId;

    public QuizAnswerDTO() {
    }

    public QuizAnswerDTO( Long answerId, Long questionId) {
        this.answerId = answerId;
     }

    public Long getIdAnswer() {
        return answerId;
    }

    public void setIdAnswer(Long answerId) {
        this.answerId = answerId;
    }

}
