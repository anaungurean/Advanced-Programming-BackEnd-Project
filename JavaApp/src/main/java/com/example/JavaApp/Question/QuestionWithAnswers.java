package com.example.JavaApp.Question;

import com.example.JavaApp.Answer.Answer;
import com.example.JavaApp.Answer.AnswerDTO;

import java.util.List;


public class QuestionWithAnswers {
    private Question question;
    private List<AnswerDTO> answers;

    private Double score;

    public QuestionWithAnswers() {
    }

    public QuestionWithAnswers(Question question, List<AnswerDTO> answers) {
        this.question = question;
        this.answers = answers;
    }

    public QuestionWithAnswers(Question question, List<AnswerDTO> answers, Double score) {
        this.question = question;
        this.answers = answers;
        this.score = score;
    }

    public Question getQuestion() {
        return question;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
