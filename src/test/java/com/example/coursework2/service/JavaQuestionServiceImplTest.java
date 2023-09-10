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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {
    private List<Question> questions;
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionServiceImpl javaQuestionService;
    @BeforeEach
    public void setUp() {
        questions = new ArrayList<>();
        questions.add(new Question("qwerty", "123"));
        questions.add(new Question("qaz", "ran"));
    }

    @Test
    public void testGetAll() {
        when(javaQuestionRepository.getAll()).thenReturn(questions);
        List<Question> actual = javaQuestionService.getAll();
        assertEquals(questions,actual);
    }

    @Test
    public void testSuccessfullyAdd() {
        String question = "qwerty";
        String answer = "123";
        when(javaQuestionRepository.add(anyString(), anyString())).thenReturn("Вопрос добавлен!");

        String result = javaQuestionService.add(question, answer);

        verify(javaQuestionRepository, times(1)).add(question, answer);
        assertEquals("Вопрос добавлен!", result);
    }
    @Test
    public void testFailAdd() {
        String question = "qwerty";
        String answer = "123";
        when(javaQuestionRepository.add(anyString(), anyString())).thenReturn("Такой вопрос уже есть");

        String result = javaQuestionService.add(question, answer);

        verify(javaQuestionRepository, times(1)).add(question, answer);
        assertEquals("Такой вопрос уже есть", result);
    }


    @Test
    public void testSuccessfullyRemove() {
        String question = "qwerty";
        String answer = "123";
        when(javaQuestionRepository.remove(anyString(), anyString())).thenReturn("Вопрос удален!");

        String result = javaQuestionService.remove(question, answer);

        verify(javaQuestionRepository, times(1)).remove(question, answer);
        assertEquals("Вопрос удален!", result);
    }
    @Test
    public void testFailRemove() {
        String question = "qwerty";
        String answer = "123";
        when(javaQuestionRepository.remove(anyString(), anyString())).thenReturn("Вопрос не найден!");

        String result = javaQuestionService.remove(question, answer);

        verify(javaQuestionRepository, times(1)).remove(question, answer);
        assertEquals("Вопрос не найден!", result);
    }
}