package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.repository.JavaQuestionRepository;
import com.example.coursework2.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {
    @Mock
    private QuestionRepository questionRepositoryMock;

    @InjectMocks
    private JavaQuestionServiceImpl out;

    private final List<Question> questions = List.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz")
    );

    @Test
    void shouldReturnTrueAfterRandom() {
        when(questionRepositoryMock.getAll()).thenReturn(questions);

        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}