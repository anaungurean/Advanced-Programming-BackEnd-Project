package com.example.JavaApp.Quiz;

import com.example.JavaApp.QuizQuestion.QuizQuestion;
import com.example.JavaApp.QuizQuestion.QuizQuestionDTO;

import java.util.List;

public class QuizDTO {
    private Long id;
    private Long userId;
    private Integer totalScore;
    private List<QuizQuestionDTO> quizQuestions;

    public QuizDTO() {
    }

    public QuizDTO(Long userId, Integer totalScore, List<QuizQuestionDTO> quizQuestions) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.quizQuestions = quizQuestions;
    }

    public QuizDTO(Long id, Long userId, Integer totalScore, List<QuizQuestionDTO> quizQuestions) {
        this.id = id;
        this.userId = userId;
        this.totalScore = totalScore;
        this.quizQuestions = quizQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public List<QuizQuestionDTO> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(List<QuizQuestionDTO> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }
}
