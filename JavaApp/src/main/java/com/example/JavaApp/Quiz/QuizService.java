package com.example.JavaApp.Quiz;
import com.example.JavaApp.Question.Question;
import com.example.JavaApp.Subject.Subject;
import com.example.JavaApp.Subject.SubjectRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<QuizClasamentDTO> getQuizClasamentByUserId(Long userId) {
        List<Object[]> results = quizRepository.getQuizClasamentByUserId(userId);
        List<QuizClasamentDTO> dtos = new ArrayList<>();

         for (Object[] result : results) {


            QuizClasamentDTO dto = new QuizClasamentDTO();

             System.out.println(result[2]);
             System.out.println(result[2].getClass().getName());

             dto.setId((Float) result[0]);
             dto.setTitle((String) result[1]);
              dto.setAverageScore((Integer) result[2]);

             dto.setTotalQuizzes((Integer) result[3]);

            dto.setQuizzesDifficulty1((Integer) result[4]);

            dto.setQuizzesDifficulty2((Integer) result[5]);

            dto.setQuizzesDifficulty3((Integer) result[6]);

            System.out.println(dto);
            dtos.add(dto);

        }
        return dtos;
    }

    public Integer getAverageScore(Long userId, Long subjectId) {

        Integer score = quizRepository.gerAverageScore(subjectId, userId);
        return score;

    }





}

