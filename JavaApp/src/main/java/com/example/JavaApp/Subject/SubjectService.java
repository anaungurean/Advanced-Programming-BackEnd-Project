package com.example.JavaApp.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
//    public List<Subject> getAllSubjects() {
//        return subjectRepository.findAll();
//    } pt java

    public List<Subject> getAllSubjects() {

        List<Long> subjectData = subjectRepository.findSubjects();
        List<Subject> subjects = new ArrayList<>();

        for(Long row : subjectData) {
            Subject subject = subjectRepository.findById(row).orElse(null);
            if(subject != null)
                 subjects.add(subject);
        }
        return subjects;
    } //de eliminat
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }
}
