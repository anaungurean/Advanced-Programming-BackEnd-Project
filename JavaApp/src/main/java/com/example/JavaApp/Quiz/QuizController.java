package com.example.JavaApp.Quiz;

import com.example.JavaApp.Question.QuestionWithAnswers;
import com.example.JavaApp.Question.QuestionWithGivenAnswers;
import com.example.JavaApp.QuizAnswer.QuizAnswer;
import com.example.JavaApp.QuizAnswer.QuizAnswerDTO;
import com.example.JavaApp.QuizQuestion.QuizQuestion;
import com.example.JavaApp.QuizQuestion.QuizQuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping("/quizzes")
    public ResponseEntity<String> createQuiz(@RequestBody QuizCreationDTO quiz) {
        try {
            double score = quiz.getScore();
            List<QuestionWithGivenAnswers> questionWithAnswers = quiz.getQuestionWithAnswers();

            QuizDTO newQuiz = new QuizDTO();
            newQuiz.setTotalScore((int) score);

            List<QuizQuestionDTO> quizQuestions = new ArrayList<>();
            for (QuestionWithGivenAnswers question : questionWithAnswers) {
                QuizQuestionDTO quizQuestion = new QuizQuestionDTO();
                quizQuestion.setQuestionId(question.getQuestion().getId());
                quizQuestion.setScore(question.getScore());
                quizQuestion.setQuizId(newQuiz.getId());
                quizQuestions.add(quizQuestion);

                List<QuizAnswerDTO> quizAnswers = new ArrayList<>();
                for (QuizAnswerDTO answer : question.getAnswers()) {
                    answer.setId(quizQuestion.getQuestionId());
                    quizAnswers.add(answer);
                }
                quizQuestion.setQuizAnswers(quizAnswers);
            }

            System.out.println(quizQuestions);

            newQuiz.setQuizQuestions(quizQuestions);


            Quiz quizMap = new Quiz(newQuiz.getId(), newQuiz.getUserId(), newQuiz.getTotalScore());
            quizService.saveQuiz(quizMap);

            return new ResponseEntity<>("Quiz created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
//    @GetMapping("/{userId}")
//    public ResponseEntity<Quiz> getQuizDetails(@PathVariable Long userId) {
//        Quiz quiz = quizService.getQuizByUserId(userId);
//        if (quiz == null) {
//            // Return an appropriate response when quiz is not found for the user ID
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(quiz);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        boolean deleted = quizService.deleteQuiz(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
