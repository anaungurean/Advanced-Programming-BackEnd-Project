package com.example.JavaApp.Quiz;

import com.example.JavaApp.Answer.Answer;
import com.example.JavaApp.Answer.AnswerDTO;
import com.example.JavaApp.Answer.AnswerService;
import com.example.JavaApp.Question.*;
import com.example.JavaApp.QuizAnswer.QuizAnswer;
import com.example.JavaApp.QuizAnswer.QuizAnswerDTO;
import com.example.JavaApp.QuizQuestion.QuizQuestion;
import com.example.JavaApp.QuizQuestion.QuizQuestionDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuizController {

    private final QuizService quizService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{quizId}/with-questions-answers")
    public ResponseEntity<Map<String, Object>> getQuestionsAndAnswersAfterId(@PathVariable Long quizId, @RequestParam(required = false) Long questionId) {
        try {
            Quiz quiz = quizService.getQuizById(quizId);

            if (quiz == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            List<QuestionWithAnswers> questionWithAnswersList = new ArrayList<>();
            double finalScore = quiz.getTotalScore();

            List<QuizQuestion> quizQuestions = quiz.getQuizQuestions();
            boolean foundStartQuestion = questionId == null;

            for (QuizQuestion quizQuestion : quizQuestions) {
                Long currentQuestionId = quizQuestion.getQuestionId();

                if (!foundStartQuestion) {
                    if (currentQuestionId.equals(questionId)) {
                        foundStartQuestion = true;
                    }
                    continue;
                }

                Double score = quizQuestion.getScore();
                Question question = questionService.getQuestionById(currentQuestionId);

                if (question != null) {
                    List<Answer> answers = answerService.getAnswersByQuestionId(currentQuestionId);
                    List<AnswerDTO> answerDTOs = new ArrayList<>();
                    boolean chosen = false;

                    for (Answer answer : answers) {
                        AnswerDTO answerDTO = new AnswerDTO();
                        answerDTO.setId(answer.getId());
                        answerDTO.setAnswerText(answer.getAnswerText());
                        answerDTO.setCorrect(answer.isCorrect());

                        // Check if the answer ID exists in QuizAnswer for the current quiz question
                        if (isAnswerSelected(quizQuestion, answer.getId())) {
                            chosen = true;
                        }
                        answerDTO.setChosen(chosen);

                        // Set other properties of AnswerDTO if needed
                        answerDTOs.add(answerDTO);
                    }

                    QuestionWithAnswers questionWithAnswers = new QuestionWithAnswers(question, answerDTOs, score);
                    questionWithAnswersList.add(questionWithAnswers);
                }
            }

            Map<String, Object> result = new HashMap<>();
            result.put("questionWithAnswersList", questionWithAnswersList);
            result.put("finalScore", finalScore);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isAnswerSelected(QuizQuestion quizQuestion, Long answerId) {
        List<QuizAnswer> quizAnswers = quizQuestion.getQuizAnswers();
        for (QuizAnswer quizAnswer : quizAnswers) {
            if (quizAnswer.getAnswerId().equals(answerId)) {
                return true;
            }
        }
        return false;
    }

    @PostMapping("/quizzes/{userId}")
    @Operation(summary = "Store the given quiz by an user")
    public ResponseEntity<String> createQuiz(@PathVariable Long userId, @RequestBody QuizCreationDTO quiz) {
        try {
            double score = quiz.getScore();
            List<QuestionWithGivenAnswers> questionWithAnswers = quiz.getQuestionWithAnswers();

            Quiz newQuiz = new Quiz();
            newQuiz.setUserId(userId);
            newQuiz.setTotalScore((double) score);
            newQuiz.setDifficulty(quiz.getDifficult());
            newQuiz.setSubjectId(quiz.getIdSubject());

            List<QuizQuestion> quizQuestions = new ArrayList<>();
            for (QuestionWithGivenAnswers question : questionWithAnswers) {
                QuizQuestion quizQuestion = new QuizQuestion();
                quizQuestion.setQuestionId(question.getQuestion().getIdQuestion());
                quizQuestion.setScore(question.getQuestion().getScore());
                quizQuestion.setQuizId(newQuiz);
                quizQuestions.add(quizQuestion);

                List<QuizAnswer> quizAnswers = new ArrayList<>();
                for (QuizAnswerDTO answer : question.getAnswers()) {
                    QuizAnswer quizAnswer = new QuizAnswer();
                    quizAnswer.setAnswerId(answer.getIdAnswer());
                    quizAnswers.add(quizAnswer);
                }
                quizQuestion.setQuizAnswers(quizAnswers);
            }


            newQuiz.setQuizQuestions(quizQuestions);

            quizService.saveQuiz(newQuiz);

            return new ResponseEntity<>("Quiz created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    @Operation(summary = "See the results of quizzes for an user" )
    public ResponseEntity<List<QuizShowDTO>> getQuizzesByUserId(@PathVariable Long userId) {
        try {
            List<QuizShowDTO> quizDTOs = quizService.getQuizzesByUserId(userId);
            return ResponseEntity.ok(quizDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(id, quiz);
        if (updatedQuiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        boolean deleted = quizService.deleteQuiz(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/clasament/{userId}")
    @Operation(summary = "See the ranking for an user" )
    public ResponseEntity<List<QuizClasamentDTO>> getQuizClasamentByUserId(@PathVariable Long userId) {
        try {
            List<QuizClasamentDTO> clasamentDTOs = quizService.getQuizClasamentByUserId(userId);
            return ResponseEntity.ok(clasamentDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
