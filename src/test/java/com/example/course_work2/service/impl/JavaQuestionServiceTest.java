package com.example.course_work2.service.impl;

import com.example.course_work2.exception.QuestionNotFoundException;
import com.example.course_work2.service.QuestionService;
import org.junit.jupiter.api.Test;

import static com.example.course_work2.service.impl.TestConstants.*;
import static org.assertj.core.api.Assertions.*;


class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @Test
    public void shouldAddQuestion() {
        int countStart = questionService.getAll().size();

        assertThat(questionService.add(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isIn(questionService.getAll());

        assertThat(questionService.getAll())
                .hasSize(countStart + 1);
    }

    @Test
    public void shouldRemoveQuestion() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);

        int countStart = questionService.getAll().size();

        assertThat(questionService.remove(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isNotIn(questionService.getAll());

        assertThat(questionService.getAll())
                .hasSize(countStart - 1);
    }

    @Test
    public void shouldThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(QUESTION_4));
    }

    @Test
    public void shouldReturnAllQuestions() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);

        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        QUESTION_1,
                        QUESTION_2,
                        QUESTION_3
                );
    }

    @Test
    public void shouldReturnRandomQuestion() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);

        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }


}