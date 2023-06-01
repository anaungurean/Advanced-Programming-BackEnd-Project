package com.example.JavaApp.Quiz;

import jakarta.persistence.criteria.CriteriaBuilder;


public class QuizClasamentDTO {

    private Float id;
    private String title;
    private Float averageScore;
    private Integer totalQuizzes;
    private Integer quizzesDifficulty1;
    private Integer quizzesDifficulty2;
    private Integer quizzesDifficulty3;

    public QuizClasamentDTO() {
    }

    public Float getId() {
        return id;
    }

    public void setId(Float id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getTotalQuizzes() {
        return totalQuizzes;
    }

    public void setTotalQuizzes(Integer totalQuizzes) {
        this.totalQuizzes = totalQuizzes;
    }

    public Integer getQuizzesDifficulty1() {
        return quizzesDifficulty1;
    }

    public void setQuizzesDifficulty1(Integer quizzesDifficulty1) {
        this.quizzesDifficulty1 = quizzesDifficulty1;
    }

    public Integer getQuizzesDifficulty2() {
        return quizzesDifficulty2;
    }

    public void setQuizzesDifficulty2(Integer quizzesDifficulty2) {
        this.quizzesDifficulty2 = quizzesDifficulty2;
    }

    public Integer getQuizzesDifficulty3() {
        return quizzesDifficulty3;
    }

    public void setQuizzesDifficulty3(Integer quizzesDifficulty3) {
        this.quizzesDifficulty3 = quizzesDifficulty3;
    }

    @Override
    public String toString() {
        return "QuizClasamentDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", averageScore=" + averageScore +
                ", totalQuizzes=" + totalQuizzes +
                ", quizzesDifficulty1=" + quizzesDifficulty1 +
                ", quizzesDifficulty2=" + quizzesDifficulty2 +
                ", quizzesDifficulty3=" + quizzesDifficulty3 +
                '}';
    }
}
