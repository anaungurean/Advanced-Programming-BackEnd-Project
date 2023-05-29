package com.example.JavaApp.Answer;

import com.example.JavaApp.Question.Question;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "http://localhost:3000")

public class AnswerController {
    private final AnswerService answerService;
    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    @Operation(summary = "List the answer")
    public List<Answer> getAllAnswer() {
        return answerService.getAllAnswer();
    }

    @PostMapping("/create")
    @Operation(summary = "Add answers")
    public ResponseEntity<String> createAnswers(@RequestBody List<Answer> answers) {
        try {
            for (Answer answer : answers) {
                answerService.addAnswer(answer);
            }
            return ResponseEntity.ok("Answers created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create answers");
        }
    }

}
