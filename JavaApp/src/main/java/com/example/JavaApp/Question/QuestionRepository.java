package com.example.JavaApp.Question;

import com.example.JavaApp.Subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByQuestionDifficultyAndSubjectId(Long difficulty, Long subjectId);
}
