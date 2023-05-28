package com.example.JavaApp.Answer;

import com.example.JavaApp.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findByQuestionId(Long id);
}
