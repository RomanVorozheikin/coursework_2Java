package com.example.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {
    private JavaQuestionServiceImpl javaQuestionService;

    @BeforeEach
    public void setUp() {

        javaQuestionService = new JavaQuestionServiceImpl();
        javaQuestionService.add("qwerty", "123");
        javaQuestionService.add("qaz", "ran");
    }

    @Test
    public void testGetAll() {
        assertEquals(2,javaQuestionService.getAll().size());
    }

    @Test
    public void add() {
        assertEquals("Такой вопрос уже есть", javaQuestionService.add("qwerty", "345"));
        assertEquals("Вопрос добавлен",javaQuestionService.add("res","ror"));
    }

    @Test
    public void remove() {
        assertEquals("Вопрос удален!", javaQuestionService.remove("qwerty", "123"));
        assertEquals("Вопрос не найден!",javaQuestionService.remove("sd","st"));
    }
}