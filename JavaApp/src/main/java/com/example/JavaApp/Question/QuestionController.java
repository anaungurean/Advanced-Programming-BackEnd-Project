package com.example.JavaApp.Question;

import com.example.JavaApp.Answer.Answer;
import com.example.JavaApp.Answer.AnswerDTO;
import com.example.JavaApp.Answer.AnswerService;
import com.example.JavaApp.Quiz.QuizService;
import com.example.JavaApp.Subject.Subject;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:3000")

public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final QuizService quizService;

    public QuestionController(QuestionService questionService, AnswerService answerService, QuizService quizService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.quizService = quizService;
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
                List<Answer> answersList = answerService.getAnswersByQuestionId(question.getId());
                List<AnswerDTO> answersDto = answersList.stream().map(
                        answerEntity -> {
                            AnswerDTO answerDto = new AnswerDTO(answerEntity.getId(),
                                    answerEntity.getAnswerText(),
                                    answerEntity.isCorrect(),
                                    false);
                            return answerDto;
                        }
                ).toList();

                QuestionWithAnswers questionWithAnswers = new QuestionWithAnswers(question, answersDto);
                questionsWithAnswers.add(questionWithAnswers);
            }

            return ResponseEntity.ok(questionsWithAnswers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/progressiveQuiz")
    @Operation(summary = "Generate progressive quiz")
    public ResponseEntity<List<QuestionWithAnswers>> getProgressiveQuestions(
            @RequestParam("userId") Long userId,
            @RequestParam("subjectId") Long subjectId
    ){
        try{
            Integer score = quizService.getAverageScore(userId,subjectId);
            int numberOfEasyQuestions=0;
            int numberOfHardQuestions=10;
            int totalScore=90;

            while(score <= totalScore)
            {
                System.out.println(numberOfEasyQuestions);
                numberOfEasyQuestions= numberOfEasyQuestions+1;
                numberOfHardQuestions= numberOfHardQuestions-1;
                totalScore=totalScore-10;
            }

            System.out.println("easy: ");
            System.out.println(numberOfEasyQuestions);
            System.out.println("hard: ");
            System.out.println(numberOfHardQuestions);

            List<Question> questions = questionService.getProgressiveQuestions(numberOfEasyQuestions,numberOfHardQuestions,subjectId);
            Collections.shuffle(questions);

            List<QuestionWithAnswers> questionsWithAnswers = new ArrayList<>();
            System.out.println(questions);
            for (Question question : questions) {
                List<Answer> answersList = answerService.getAnswersByQuestionId(question.getId());
                List<AnswerDTO> answersDto = answersList.stream().map(
                        answerEntity -> {
                            AnswerDTO answerDto = new AnswerDTO(answerEntity.getId(),
                                    answerEntity.getAnswerText(),
                                    answerEntity.isCorrect(),
                                    false);
                            return answerDto;
                        }
                ).toList();

                QuestionWithAnswers questionWithAnswers = new QuestionWithAnswers(question, answersDto);
                questionsWithAnswers.add(questionWithAnswers);
            }

            return ResponseEntity.ok(questionsWithAnswers);



        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}


