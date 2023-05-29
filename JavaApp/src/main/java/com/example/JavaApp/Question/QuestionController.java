package com.example.JavaApp.Question;

import com.example.JavaApp.Answer.Answer;
import com.example.JavaApp.Answer.AnswerService;
import com.example.JavaApp.Subject.Subject;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:3000")

public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @Autowired
    public QuestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }
    @GetMapping
    @Operation(summary = "List the questions")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @PostMapping("/create")
    @Operation(summary = "Add question")
    public ResponseEntity<String> createQuestion(@RequestBody Question question) {
        try {
            questionService.addQuestion(question);
            return ResponseEntity.ok("Question created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create question");
        }
    }

    @GetMapping("/quiz")
    @Operation(summary = "Generate quiz")
    public ResponseEntity<List<QuestionWithAnswers>> getQuestionsByDifficultyAndSubjectId(
            @RequestParam("difficulty") Long difficulty,
            @RequestParam("subjectId") Long subjectId
    ) {
        try {
            List<Question> questions = questionService.getQuestionsByDifficultyAndSubjectId(difficulty, subjectId);
            List<QuestionWithAnswers> questionsWithAnswers = new ArrayList<>();
            System.out.println(questions);
            for (Question question : questions) {
                List<Answer> answers = answerService.getAnswersByQuestionId(question.getId());
                QuestionWithAnswers questionWithAnswers = new QuestionWithAnswers(question, answers);
                questionsWithAnswers.add(questionWithAnswers);
            }

            return ResponseEntity.ok(questionsWithAnswers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}


