package com.example.JavaApp.Quiz;

import com.example.JavaApp.Question.Question;
import com.example.JavaApp.Question.QuestionWithAnswers;
import com.example.JavaApp.Question.QuestionWithGivenAnswers;
import com.example.JavaApp.Subject.Subject;

import java.util.List;

public class QuizCreationDTO {

    private Long difficult;
    private Long idSubject;
    private double score;
    private List<QuestionWithGivenAnswers>  questionWithAnswers;

    public QuizCreationDTO() {
    }

    public QuizCreationDTO(Long difficult, Long idSubject, double score, List<QuestionWithGivenAnswers> questionWithAnswers) {
        this.difficult = difficult;
        this.idSubject = idSubject;
        this.score = score;
        this.questionWithAnswers = questionWithAnswers;
    }

    public Long getDifficult() {
        return difficult;
    }

    public void setDifficult(Long difficult) {
        this.difficult = difficult;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<QuestionWithGivenAnswers> getQuestionWithAnswers() {
        return questionWithAnswers;
    }

    public void setQuestionWithAnswers(List<QuestionWithGivenAnswers> questionWithAnswers) {
        this.questionWithAnswers = questionWithAnswers;
    }
}
