package com.example.JavaApp.QuizAnswer;

import com.example.JavaApp.QuizQuestion.QuizQuestion;

public class QuizAnswerDTO {
    private Long id;
    private Long answerId;
    private Long questionId;

    public QuizAnswerDTO() {
    }

    public QuizAnswerDTO(Long id, Long answerId, Long questionId) {
        this.id = id;
        this.answerId = answerId;
        this.questionId = questionId;
    }

    public QuizAnswerDTO(Long answerId, Long questionId) {
        this.answerId = answerId;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
