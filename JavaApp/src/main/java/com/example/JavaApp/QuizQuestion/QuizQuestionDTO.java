package com.example.JavaApp.QuizQuestion;

import com.example.JavaApp.Quiz.Quiz;
import com.example.JavaApp.Quiz.QuizDTO;
import com.example.JavaApp.QuizAnswer.QuizAnswerDTO;

import java.util.List;

public class QuizQuestionDTO {
    private Long id;
    private Long quizId;
    private Long questionId;
    private Long score;
    private List<QuizAnswerDTO> quizAnswers;

    public QuizQuestionDTO(Long id, Long quizId, Long questionId, Long score, List<QuizAnswerDTO> quizAnswers) {
        this.id = id;
        this.quizId = quizId;
        this.questionId = questionId;
        this.score = score;
        this.quizAnswers = quizAnswers;
    }

    public QuizQuestionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public List<QuizAnswerDTO> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(List<QuizAnswerDTO> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }
}
