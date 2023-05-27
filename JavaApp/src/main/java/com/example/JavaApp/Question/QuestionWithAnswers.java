package com.example.JavaApp.Question;

import com.example.JavaApp.Answer.Answer;

import java.util.List;


public class QuestionWithAnswers {
    private Question question;
    private List<Answer> answers;

    public QuestionWithAnswers(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
