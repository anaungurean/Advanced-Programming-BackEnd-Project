package com.example.JavaApp.Quiz;

import com.example.JavaApp.Question.QuestionWithAnswers;
import com.example.JavaApp.Question.QuestionWithGivenAnswers;
import com.example.JavaApp.QuizAnswer.QuizAnswer;
import com.example.JavaApp.QuizAnswer.QuizAnswerDTO;
import com.example.JavaApp.QuizQuestion.QuizQuestion;
import com.example.JavaApp.QuizQuestion.QuizQuestionDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/quizzes/{userId}")
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
}
