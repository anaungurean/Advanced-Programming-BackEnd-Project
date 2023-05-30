package com.example.JavaApp.Quiz;
import com.example.JavaApp.QuizQuestion.QuizQuestion;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long idUser;

    @Column(name = "total_score")
    private int totalScore;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;

    public Quiz() {
    }

    public Quiz(Long id, int totalScore) {
        this.id = id;
        this.totalScore = totalScore;
    }

    public Quiz(Long idUser, int totalScore, List<QuizQuestion> quizQuestions) {
        this.idUser = idUser;
        this.totalScore = totalScore;
        this.quizQuestions = quizQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public List<QuizQuestion> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }
}
