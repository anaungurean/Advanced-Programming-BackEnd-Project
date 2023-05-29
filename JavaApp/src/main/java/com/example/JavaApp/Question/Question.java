package com.example.JavaApp.Question;
import com.example.JavaApp.Subject.Subject;
import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "question_difficulty")
    private int questionDifficulty;

    public Question() {
    }

    public Question(Subject subject, String questionText, int questionDifficulty) {
        this.subject = subject;
        this.questionText = questionText;
        this.questionDifficulty = questionDifficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject=" + subject +
                ", questionText='" + questionText + '\'' +
                ", questionDifficulty=" + questionDifficulty +
                '}';
    }
}
