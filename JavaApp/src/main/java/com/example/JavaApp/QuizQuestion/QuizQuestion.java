package com.example.JavaApp.QuizQuestion;
import com.example.JavaApp.Quiz.Quiz;
import com.example.JavaApp.QuizAnswer.QuizAnswer;
import com.example.JavaApp.QuizAnswer.QuizAnswerDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quiz_questions")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quizId;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "score")
    private Double  score;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_question_id")
    private List<QuizAnswer> quizAnswers;

    public QuizQuestion() {
    }

    public QuizQuestion(Long id, Quiz quizId, Long questionId , Double  score) {
        this.id = id;
        this.quizId = quizId;
        this.questionId = questionId;
        this.score = score;
    }

    public QuizQuestion(Quiz quizId, Long questionId, Double  score) {
        this.quizId = quizId;
        this.questionId = questionId;
        this.score = score;
    }

    public Quiz getQuizId() {
        return quizId;
    }

    public void setQuizId(Quiz quizId) {
        this.quizId = quizId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Double  getScore() {
        return score;
    }

    public void setScore(Double  score) {
        this.score = score;
    }
    public List<QuizAnswer> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(List<QuizAnswer> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }
    @Override
    public String toString() {
        return "QuizQuestion{" +
                "id=" + id +
                ", quizId=" + quizId +
                ", questionId=" + questionId +
                ", score=" + score +
                '}';
    }
}
