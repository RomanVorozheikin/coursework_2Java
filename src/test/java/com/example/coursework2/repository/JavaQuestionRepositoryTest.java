package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private JavaQuestionRepository javaQuestionRepository;
    private List<Question> questions;
    @BeforeEach
    public void setUp() {
        questions = new ArrayList<>();
        questions.add(new Question("qwerty", "345"));
        questions.add(new Question("345", "zxc"));
        javaQuestionRepository = new JavaQuestionRepository(questions);
    }

    @Test
    public void add() {
        assertEquals("Такой вопрос уже есть", javaQuestionRepository.add("qwerty", "345"));
        assertEquals("Вопрос добавлен",javaQuestionRepository.add("res","ror"));
    }

    @Test
    public void remove() {
        assertEquals("Вопрос удален!", javaQuestionRepository.remove("qwerty", "345"));
        assertEquals("Вопрос не найден!",javaQuestionRepository.remove("sd","st"));
    }

    @Test
    void getAll() {
        assertEquals(2, questions.size());
    }
}