package com.example.JavaApp.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> getAnswersByQuestionId(Long id) {
        return answerRepository.findByQuestionId(id);

    }
}
