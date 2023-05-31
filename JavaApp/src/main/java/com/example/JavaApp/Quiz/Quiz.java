package com.example.JavaApp.Quiz;
import com.example.JavaApp.QuizQuestion.QuizQuestion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_score")
    private Integer totalScore;
    @JsonIgnore
    @OneToMany(mappedBy = "quizId", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;


    public Quiz() {
    }

    public Quiz(Long id, Long userId, Integer totalScore) {
        this.id = id;
        this.userId = userId;
        this.totalScore = totalScore;
    }

    public Quiz(Long userId, Integer totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
    }

    public List<QuizQuestion> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
        this.quizQuestions = quizQuestions;
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

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
