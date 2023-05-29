package com.example.JavaApp.Question;

import com.example.JavaApp.Subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

//    List<Question> findByQuestionDifficultyAndSubjectId(Long difficulty, Long subjectId); pt Java

    @Query(value = "SELECT * FROM TABLE(generate_question_list(:p_question_difficulty, :p_subject_id))", nativeQuery = true)
    List<Long> findByQuestionDifficultyAndSubjectId(
            @Param("p_question_difficulty") Long difficulty,
            @Param("p_subject_id") Long subjectId
    ); //de eliminat

}
