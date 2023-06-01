package com.example.JavaApp.Quiz;
import com.example.JavaApp.Subject.Subject;
import com.example.JavaApp.Subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final SubjectRepository subjectRepository;

    public QuizService(QuizRepository quizRepository, SubjectRepository subjectRepository) {
        this.quizRepository = quizRepository;
        this.subjectRepository = subjectRepository;
    }

    @Autowired

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }


    public Quiz updateQuiz(Long id, Quiz quiz) {
        if (quizRepository.existsById(id)) {
            quiz.setId(id);
            return quizRepository.save(quiz);
        }
        return null;
    }

    public boolean deleteQuiz(Long id) {
        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public void saveQuiz(Quiz newQuiz) {
        quizRepository.save(newQuiz);
    }



    public List<QuizShowDTO> getQuizzesByUserId(Long userId) {
        List<Quiz> quizzes = quizRepository.findByUserId(userId);

        List<QuizShowDTO> quizDTOs = new ArrayList<>();
        for (Quiz quiz : quizzes) {
            QuizShowDTO quizDTO = new QuizShowDTO();
            quizDTO.setId(quiz.getId());
            quizDTO.setTotalScore(quiz.getTotalScore());
            quizDTO.setSubjectId(quiz.getSubjectId());
            quizDTO.setDifficulty(quiz.getDifficulty());
             Subject subject = subjectRepository.findById(quiz.getSubjectId()).orElse(null);
            if (subject != null) {
                quizDTO.setSubjectTitle(subject.getTitle());
            }

            quizDTOs.add(quizDTO);
        }

        return quizDTOs;
    }

}

