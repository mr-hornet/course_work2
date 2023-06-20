package com.example.course_work2.service.impl;

import com.example.course_work2.exception.IncorrectQuestionAmountException;
import com.example.course_work2.service.ExaminerService;
import com.example.course_work2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static com.example.course_work2.service.impl.TestConstants.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectQuestionAmountException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));
    }

    @Test
    public void shouldReturnQuestions() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3
        );

        int questionAmount = MOCK_QUESTIONS.size() - 2;

        assertThat(examinerService.getQuestions(questionAmount)).hasSize(questionAmount);
    }

}