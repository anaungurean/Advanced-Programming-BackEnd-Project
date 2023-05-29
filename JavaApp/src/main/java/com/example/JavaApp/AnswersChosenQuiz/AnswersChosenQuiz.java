package com.example.JavaApp.AnswersChosenQuiz;

import com.example.JavaApp.QuestionQuiz.QuestionQuiz;
import jakarta.persistence.*;

@Entity
@Table(name = "answers_chosen_quiz")
public class AnswersChosenQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "answer_id")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "question_quiz_id")
    private QuestionQuiz questionQuiz;

    public AnswersChosenQuiz() {
    }

    public AnswersChosenQuiz(Long answerId, QuestionQuiz questionQuiz) {
        this.answerId = answerId;
        this.questionQuiz = questionQuiz;
    }

    public AnswersChosenQuiz(Long id, Long answerId, QuestionQuiz questionQuiz) {
        this.id = id;
        this.answerId = answerId;
        this.questionQuiz = questionQuiz;
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

    public QuestionQuiz getQuestionQuiz() {
        return questionQuiz;
    }

    public void setQuestionQuiz(QuestionQuiz questionQuiz) {
        this.questionQuiz = questionQuiz;
    }

    @Override
    public String toString() {
        return "AnswersChosenQuiz{" +
                "id=" + id +
                ", answerId=" + answerId +
                ", questionQuiz=" + questionQuiz +
                '}';
    }
}
