package com.example.JavaApp.QuizQuestion;
import com.example.JavaApp.Quiz.Quiz;
import jakarta.persistence.*;


@Entity
@Table(name = "quiz_questions")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "question_id")
    private Long idQuestion;

    @Column(name = "user_answer_id")
    private Long idAnswer;
    @Column
    private int score;

    public QuizQuestion() {
    }

    public QuizQuestion(Quiz quiz, Long idQuestion, Long idAnswer, int score) {
        this.quiz = quiz;
        this.idQuestion = idQuestion;
        this.idAnswer = idAnswer;
        this.score = score;
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

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
