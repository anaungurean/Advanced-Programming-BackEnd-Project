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

        List<Question> questions = questionRepository.findByQuestionDifficultyAndSubjectId(difficulty, subjectId);
        Collections.shuffle(questions);
        int totalQuestions = questions.size();
        int numQuestionsToRetrieve = Math.min(10, totalQuestions);
        return questions.subList(0, numQuestionsToRetrieve);
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Question not found"));
    }

    public List<Question> getProgressiveQuestions(Integer numberOfEasyQuestions, Integer numberOfHardQuestions, Long subjectId) {

        List<Question> questions = new ArrayList<>();

        if(numberOfEasyQuestions>0){
            List<Question> easyQuestions = questionRepository.findByQuestionDifficultyAndSubjectId(1L, subjectId);
            Collections.shuffle(easyQuestions);
            int totalQuestions = easyQuestions.size();
            int numQuestionsToRetrieve = Math.min(numberOfEasyQuestions, totalQuestions);
            questions.addAll(easyQuestions.subList(0,numQuestionsToRetrieve)) ;
        }

        if(numberOfHardQuestions>0){
            List<Question> hardQuestions = questionRepository.findByQuestionDifficultyAndSubjectId(2L, subjectId);
            Collections.shuffle(hardQuestions);
            int totalQuestions = hardQuestions.size();
            int numQuestionsToRetrieve = Math.min(numberOfHardQuestions, totalQuestions);
            questions.addAll(hardQuestions.subList(0,numQuestionsToRetrieve)) ;
        }

        return  questions;

    }

}

