package com.example.course_work2.service.impl;

import com.example.course_work2.model.Question;

import java.util.Collection;
import java.util.Set;

public class TestConstants {

    public static final Question QUESTION_1 = new Question("why1", "because1");
    public static final Question QUESTION_2 = new Question("why2", "because2");
    public static final Question QUESTION_3 = new Question("why3", "because3");
    public static final Question QUESTION_4 = new Question("why4", "because4");
    public static final Question QUESTION_5 = new Question("why5", "because5");

    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5
    );

}
