package com.example.JavaApp.Quiz;

import com.example.JavaApp.AnswersChosenQuiz.AnswersChosenQuiz;
import com.example.JavaApp.AnswersTextQuiz.AnswersTextQuiz;
import com.example.JavaApp.QuestionQuiz.QuestionQuiz;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "difficulty")
    private Long difficulty;

    @Column(name = "score_quiz")
    private Long scoreQuiz;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuestionQuiz> questionQuiz;

//    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
//    private List<AnswersChosenQuiz> answerChosenQuiz;
//    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
//    private List<AnswersTextQuiz> answersTextQuiz;
    public Quiz() {
    }

    public Quiz(Long userId, Long subjectId, Long difficulty, Long scoreQuiz) {
        this.userId = userId;
        this.subjectId = subjectId;
        this.difficulty = difficulty;
        this.scoreQuiz = scoreQuiz;
    }
    public Quiz(Long userId, Long subjectId, Long difficulty, Long scoreQuiz,
                List<QuestionQuiz> questionQuiz, List<AnswersChosenQuiz> answerChosenQuiz,
                List<AnswersTextQuiz> answersTextQuiz) {
        this.userId = userId;
        this.subjectId = subjectId;
        this.difficulty = difficulty;
        this.scoreQuiz = scoreQuiz;
        this.questionQuiz = questionQuiz;
//        this.answerChosenQuiz = answerChosenQuiz;
//        this.answersTextQuiz = answersTextQuiz;
    }

    public Quiz(Long id, Long userId, Long subjectId, Long difficulty, Long scoreQuiz, List<QuestionQuiz> questionQuiz) {
        this.id = id;
        this.userId = userId;
        this.subjectId = subjectId;
        this.difficulty = difficulty;
        this.scoreQuiz = scoreQuiz;
        this.questionQuiz = questionQuiz;
    }

    public Quiz(Long userId, Long subjectId, Long difficulty, Long scoreQuiz, List<QuestionQuiz> questionQuiz) {
        this.userId = userId;
        this.subjectId = subjectId;
        this.difficulty = difficulty;
        this.scoreQuiz = scoreQuiz;
        this.questionQuiz = questionQuiz;
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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public Long getScoreQuiz() {
        return scoreQuiz;
    }

    public void setScoreQuiz(Long scoreQuiz) {
        this.scoreQuiz = scoreQuiz;
    }

    public List<QuestionQuiz> getQuestionQuiz() {
        return questionQuiz;
    }

    public void setQuestionQuiz(List<QuestionQuiz> questionQuiz) {
        this.questionQuiz = questionQuiz;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", userId=" + userId +
                ", subjectId=" + subjectId +
                ", difficulty=" + difficulty +
                ", scoreQuiz=" + scoreQuiz +
                ", questionQuiz=" + questionQuiz +
                '}';
    }
}

