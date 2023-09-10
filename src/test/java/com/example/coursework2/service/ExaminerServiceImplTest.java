package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private List<Question> javaQuestions;
    private List<Question> mathQuestions;
    private List<Question> questions;
    @Mock
    private QuestionService javaQuestionService;
    @Mock
    private QuestionService mathQuestionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(mathQuestionService, javaQuestionService);
        Question question1 = new Question("qwe", "ewq");
        Question question2 = new Question("zxc", "cxz");
        Question question3 = new Question("zxc", "cxz");

        Question question4 = new Question("123", "456");
        Question question5 = new Question("789", "012");
        Question question6 = new Question("345", "678");

        javaQuestions = new ArrayList<>();
        javaQuestions.add(question1);
        javaQuestions.add(question2);
        javaQuestions.add(question3);

        mathQuestions = new ArrayList<>();
        mathQuestions.add(question4);
        mathQuestions.add(question5);
        mathQuestions.add(question6);

        questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
    }
    @Test
    void testGetQuestions() throws MoreThanInServiceException {
        int amount = 6;
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("qwe", "ewq"),
                new Question("zxc", "cxz"),
                new Question("zxc", "cxz"),
                new Question("asd", "dsa"),
                new Question("qwe", "ewq")
        );
        when(mathQuestionService.getRandomQuestion()).thenReturn(
                new Question("123", "456"),
                new Question("789", "012"),
                new Question("345", "678"),
                new Question("234", "432"),
                new Question("123", "321")
        );
        assertEquals(questions.size(),examinerService.getQuestions(amount).size());
    }

    @Test
    void testGetQuestionException() {

        int amount = 7;
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);

        assertThrows(MoreThanInServiceException.class, () -> examinerService.getQuestions(amount));
    }
}