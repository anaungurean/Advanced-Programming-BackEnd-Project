package com.example.JavaApp.QuizAnswer;

import com.example.JavaApp.QuizQuestion.QuizQuestion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "quiz_answers")
public class QuizAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_question_id")
    private QuizQuestion quizQuestion;

    @Column(name = "answer_id")
    private Long answerId;

    public QuizAnswer() {
    }

    public QuizAnswer(Long id, QuizQuestion quizQuestion, Long answerId) {
        this.id = id;
        this.quizQuestion = quizQuestion;
        this.answerId = answerId;
    }

    public QuizAnswer(QuizQuestion quizQuestion, Long answerId) {
        this.quizQuestion = quizQuestion;
        this.answerId = answerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizQuestion getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(QuizQuestion quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getQuizQuestionId() {
        return quizQuestion.getId();
    }
}
