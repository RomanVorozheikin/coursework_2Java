package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private List<Question> questions;
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        Question question1 = new Question("Столица России", "Москва");
        Question question2 = new Question("Столица Белорусии", "Минск");
        Question question3 = new Question("Столица Франции", "Париж");

        questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }
    @Test
    void testGetQuestions() throws MoreThanInServiceException {

        when(questionService.getAll()).thenReturn(questions);
        int amount = 2;

        Set<String> actual = examinerService.getQuestions(amount);

        assertEquals(amount, actual.size());
        verify(questionService).getAll();
    }

    @Test
    void testGetQuestionException() {
        when(questionService.getAll()).thenReturn(questions);

        int amount = 4;

        assertThrows(MoreThanInServiceException.class, () -> examinerService.getQuestions(amount));
        verify(questionService).getAll();
    }
}