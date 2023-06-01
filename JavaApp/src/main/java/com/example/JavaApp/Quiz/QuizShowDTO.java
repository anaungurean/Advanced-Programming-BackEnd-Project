package com.example.JavaApp.Quiz;

public class QuizShowDTO {
    private Long id;
    private Double totalScore;
    private Long subjectId;
    private String subjectTitle;
    private Long difficulty;
    public QuizShowDTO() {
    }

    public QuizShowDTO(Long id, Double totalScore, Long subjectId, String subjectTitle, Long difficulty) {
        this.id = id;
        this.totalScore = totalScore;
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
        this.difficulty = difficulty;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }
}
