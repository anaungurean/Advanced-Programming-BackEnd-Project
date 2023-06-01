package com.example.JavaApp.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByUserId(Long userId);
    @Query(value = "SELECT s.id, s.title, COALESCE(AVG(COALESCE(q.total_score, 0)), 0) AS average_score, " +
            "COUNT(q.id) AS total_quizzes, COUNT(CASE WHEN q.difficulty = 1 THEN q.id END) AS quizzes_difficulty_1, " +
            "COUNT(CASE WHEN q.difficulty = 2 THEN q.id END) AS quizzes_difficulty_2, " +
            "COUNT(CASE WHEN q.difficulty = 3 THEN q.id END) AS quizzes_difficulty_3 " +
            "FROM subjects s " +
            "LEFT JOIN quizzes q ON s.id = q.subject_id AND q.user_id = :userId " +
            "GROUP BY s.id, s.title " +
            "ORDER BY average_score DESC, s.id ASC", nativeQuery = true)
    List<Object[]> getQuizClasamentByUserId(@Param("userId") Long userId);




}

