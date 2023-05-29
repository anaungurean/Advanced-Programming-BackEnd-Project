package com.example.JavaApp.AnswersTextQuiz;

import com.example.JavaApp.QuestionQuiz.QuestionQuiz;
import jakarta.persistence.*;

@Entity
@Table(name = "answers_text_quiz")
public class AnswersTextQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_quiz_id")
    private QuestionQuiz questionQuiz;

    @Column(name = "given_answer")
    private String givenAnswer;

    public AnswersTextQuiz() {
    }

    public AnswersTextQuiz(QuestionQuiz questionQuiz, String givenAnswer) {
        this.questionQuiz = questionQuiz;
        this.givenAnswer = givenAnswer;
    }

    public AnswersTextQuiz(Long id, QuestionQuiz questionQuiz, String givenAnswer) {
        this.id = id;
        this.questionQuiz = questionQuiz;
        this.givenAnswer = givenAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionQuiz getQuestionQuiz() {
        return questionQuiz;
    }

    public void setQuestionQuiz(QuestionQuiz questionQuiz) {
        this.questionQuiz = questionQuiz;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    @Override
    public String toString() {
        return "AnswersTextQuiz{" +
                "id=" + id +
                ", questionQuiz=" + questionQuiz +
                ", givenAnswer='" + givenAnswer + '\'' +
                '}';
    }
}
