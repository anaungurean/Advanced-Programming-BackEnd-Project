package com.example.JavaApp.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
//        @Query("SELECT q FROM Quiz q WHERE q.userId = :userId")
//        Quiz findByUserId(@Param("userId") Long userId);

 }

