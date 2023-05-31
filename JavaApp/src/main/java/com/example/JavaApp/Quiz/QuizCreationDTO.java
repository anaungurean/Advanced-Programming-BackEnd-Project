package com.example.JavaApp.Quiz;

import com.example.JavaApp.Question.Question;
import com.example.JavaApp.Question.QuestionWithAnswers;
import com.example.JavaApp.Question.QuestionWithGivenAnswers;
import com.example.JavaApp.Subject.Subject;

import java.util.List;

public class QuizCreationDTO {

    private double score;
    private List<QuestionWithGivenAnswers>  questionWithAnswers;

    public List<QuestionWithGivenAnswers> getQuestionWithAnswers() {
        return questionWithAnswers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setQuestionWithAnswers(List<QuestionWithGivenAnswers> questionWithAnswers) {
        this.questionWithAnswers = questionWithAnswers;
    }
}
