package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionServiceMock;

    @Mock
    private QuestionService mathQuestionServiceMock;

    private ExaminerServiceImpl out;

    @BeforeEach
    public void initOut() {
        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
    }

    private final List<Question> javaQuestions = new ArrayList<>(List.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz")));


    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz"),
            new Question("123", "321"),
            new Question("234", "432"),
            new Question("345", "543")));

    @Test
    void shouldReturnExceptionWhenAmountIncorrect() {
        when(javaQuestionServiceMock.getAll()).thenReturn(javaQuestions);

        assertThrows(MoreThanInServiceException.class, () -> out.getQuestions(7));
    }

    @Test
    void shouldReturnSetWithAmountQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(javaQuestions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("qwe", "ewq"),
                new Question("zxc", "cxz"),
                new Question("zxc", "cxz"),
                new Question("asd", "dsa"),
                new Question("qwe", "ewq")
        );
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("123", "321"),
                new Question("345", "543"),
                new Question("345", "543"),
                new Question("234", "432"),
                new Question("123", "321")
        );

        assertEquals(questions.size(), out.getQuestions(6).size());
    }
}