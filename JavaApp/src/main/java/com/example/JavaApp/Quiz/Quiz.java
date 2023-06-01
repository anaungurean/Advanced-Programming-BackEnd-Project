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
    private Double totalScore;
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "difficulty")
    private Long difficulty;
    @JsonIgnore
    @OneToMany(mappedBy = "quizId", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;


    public Quiz() {
    }

    public Quiz(Long userId, Double totalScore, Long subjectId, Long difficulty, List<QuizQuestion> quizQuestions) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.subjectId = subjectId;
        this.difficulty = difficulty;
        this.quizQuestions = quizQuestions;
    }

    public Quiz(Long id, Long userId, Double totalScore, Long subjectId, Long difficulty, List<QuizQuestion> quizQuestions) {
        this.id = id;
        this.userId = userId;
        this.totalScore = totalScore;
        this.subjectId = subjectId;
        this.difficulty = difficulty;
        this.quizQuestions = quizQuestions;
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

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
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
}
