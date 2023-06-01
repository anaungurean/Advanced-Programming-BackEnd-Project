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

    public AnswerDTO() {
    }

    public AnswerDTO(String answerText, boolean correct, boolean chosen) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}
