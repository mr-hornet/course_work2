package com.example.course_work2.service;

import com.example.course_work2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
