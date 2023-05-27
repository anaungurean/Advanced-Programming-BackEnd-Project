package com.example.JavaApp.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();

    }
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }
}
