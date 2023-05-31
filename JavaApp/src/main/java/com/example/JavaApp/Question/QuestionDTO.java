package com.example.JavaApp.Question;

public class QuestionDTO {
    private Long idQuestion;
    private Double score;

    public QuestionDTO() {
    }

    public QuestionDTO(Long idQuestion, Double score) {
        this.idQuestion = idQuestion;
        this.score = score;
    }

    public QuestionDTO(Double score) {
        this.score = score;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
