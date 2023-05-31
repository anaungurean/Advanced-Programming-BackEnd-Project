package com.example.JavaApp.Question;

import com.example.JavaApp.Answer.AnswerDTO;

import java.util.List;

import com.example.JavaApp.QuizAnswer.QuizAnswer;
import com.example.JavaApp.QuizAnswer.QuizAnswerDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class QuestionWithGivenAnswers {
    private QuestionDTO question;
    private List<QuizAnswerDTO> answers;
    private Long score;
}
