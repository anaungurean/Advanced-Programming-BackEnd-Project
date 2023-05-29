package com.example.JavaApp.Answer;

import com.example.JavaApp.Question.Question;
import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "correct")
    private boolean correct;

    @Column(name = "chosen")
    private boolean chosen;

    public Answer() {
    }

    public Answer(Question question, String answerText, boolean correct, boolean chosen) {
        this.question = question;
        this.answerText = answerText;
        this.correct = correct;
        this.chosen = chosen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question=" + question +
                ", answerText='" + answerText + '\'' +
                ", correct=" + correct +
                ", chosen=" + chosen +
                '}';
    }
}
