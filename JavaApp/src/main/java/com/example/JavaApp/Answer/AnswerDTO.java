package com.example.JavaApp.Answer;

public class AnswerDTO {

    private Long id;
    private String answerText;
    private boolean correct;
    private boolean chosen;

    public AnswerDTO(Long id, String answerText, boolean correct, boolean chosen) {
        this.id = id;
        this.answerText = answerText;
        this.correct = correct;
        this.chosen = chosen;
    }

    public Long getId() {
        return id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public boolean isChosen() {
        return chosen;
    }
}
