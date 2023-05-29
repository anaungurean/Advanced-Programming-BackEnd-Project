package com.example.JavaApp.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByDifficultyAndSubjectId(Long difficulty, Long subjectId) {

        List<Long> questionData = questionRepository.findByQuestionDifficultyAndSubjectId(difficulty, subjectId);
        List<Question> questions = new ArrayList<>();

        for (Long row : questionData) {
            Question question = questionRepository.findById(row).orElse(null);
            if (question != null) {
                questions.add(question);
            }
        }
        return questions; //de eliminat
    }
//        List<Question> questions = questionRepository.findByQuestionDifficultyAndSubjectId(difficulty, subjectId);
//        Collections.shuffle(questions);
//        int totalQuestions = questions.size();
//        int numQuestionsToRetrieve = Math.min(10, totalQuestions);
//        return questions.subList(0, numQuestionsToRetrieve); pt java
    }

