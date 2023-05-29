package com.example.JavaApp.QuestionQuiz;

import com.example.JavaApp.AnswersChosenQuiz.AnswersChosenQuiz;
import com.example.JavaApp.AnswersTextQuiz.AnswersTextQuiz;
import com.example.JavaApp.Quiz.Quiz;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question_quiz")
public class QuestionQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "score_question")
    private Long scoreQuestion;
    @OneToMany(mappedBy = "questionQuiz", cascade = CascadeType.ALL)
    private List<AnswersChosenQuiz> answerChosenQuiz;

    @OneToMany(mappedBy = "questionQuiz", cascade = CascadeType.ALL)
    private List<AnswersTextQuiz> answersTextQuiz;
    public QuestionQuiz() {
    }
    public QuestionQuiz(Quiz quiz, Long questionId, Long scoreQuestion,
                        List<AnswersChosenQuiz> answerChosenQuiz, List<AnswersTextQuiz> answersTextQuiz) {
        this.quiz = quiz;
        this.questionId = questionId;
        this.scoreQuestion = scoreQuestion;
        this.answerChosenQuiz = answerChosenQuiz;
        this.answersTextQuiz = answersTextQuiz;
    }

    public QuestionQuiz(Quiz quiz, Long questionId, Long scoreQuestion) {
        this.quiz = quiz;
        this.questionId = questionId;
        this.scoreQuestion = scoreQuestion;
    }

    public QuestionQuiz(Long id, Quiz quiz, Long questionId, Long scoreQuestion) {
        this.id = id;
        this.quiz = quiz;
        this.questionId = questionId;
        this.scoreQuestion = scoreQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getScoreQuestion() {
        return scoreQuestion;
    }

    public void setScoreQuestion(Long scoreQuestion) {
        this.scoreQuestion = scoreQuestion;
    }

    @Override
    public String toString() {
        return "QuestionQuiz{" +
                "id=" + id +
                ", quiz=" + quiz +
                ", questionId=" + questionId +
                ", scoreQuestion=" + scoreQuestion +
                '}';
    }
}
