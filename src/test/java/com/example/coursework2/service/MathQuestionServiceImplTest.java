package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.repository.MathQuestionRepository;
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
class MathQuestionServiceImplTest {

    private List<Question> questions;

    @Mock
    private MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    private MathQuestionServiceImpl mathQuestionService;

    @BeforeEach
    public void setUp() {
        questions = new ArrayList<>();
        questions.add(new Question("wsx", "456"));
        questions.add(new Question("azx", "123"));
    }
    @Test
    public void testGetAll() {
        when(mathQuestionRepository.getAll()).thenReturn(questions);

        List<Question> actual = mathQuestionService.getAll();

        assertEquals(questions,actual);
    }

    @Test
    public void testSuccessfullyAdd() {
        String question = "qwerty";
        String answer = "234";

        when(mathQuestionRepository.add(anyString(), anyString())).thenReturn("Вопрос добавлен");

        String actual = mathQuestionService.add(question, answer);

        verify(mathQuestionRepository, times(1)).add(question, answer);
        assertEquals("Вопрос добавлен", actual);
    }
    @Test
    public void testFailAdd() {
        String question = "qwerty";
        String answer = "234";

        when(mathQuestionRepository.add(anyString(), anyString())).thenReturn("Такой вопрос уже есть!");

        String actual = mathQuestionService.add(question, answer);

        verify(mathQuestionRepository, times(1)).add(question, answer);
        assertEquals("Такой вопрос уже есть!", actual);
    }

    @Test
    public void testSuccessfullyRemove() {
        String question = "qwerty";
        String answer = "234";

        when(mathQuestionRepository.remove(anyString(), anyString())).thenReturn("Вопрос удален!");

        String actual = mathQuestionService.remove(question, answer);

        verify(mathQuestionRepository, times(1)).remove(question, answer);
        assertEquals("Вопрос удален!", actual);
    }
    @Test
    public void testFailRemove() {
        String question = "qwerty";
        String answer = "234";

        when(mathQuestionRepository.remove(anyString(), anyString())).thenReturn("Вопрос не найден!");

        String actual = mathQuestionService.remove(question, answer);

        verify(mathQuestionRepository, times(1)).remove(question, answer);
        assertEquals("Вопрос не найден!", actual);
    }
}