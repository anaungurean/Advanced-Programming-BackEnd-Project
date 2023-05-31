package com.example.JavaApp.Question;

import com.example.JavaApp.Subject.Subject;

public class QuestionDTO {
    private Long id;
    private Long idSubject;

    public QuestionDTO() {
    }

    public QuestionDTO(Long idSubject) {
        this.idSubject = idSubject;
    }

    public QuestionDTO(Long id, Long idSubject) {
        this.id = id;
        this.idSubject = idSubject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }
}
