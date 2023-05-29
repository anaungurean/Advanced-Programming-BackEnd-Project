package com.example.JavaApp.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.JavaApp.Quiz.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}