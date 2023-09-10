package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private MathQuestionRepository mathQuestionRepository;

    @BeforeEach
    public void setUp() {
        List<Question> questions = new ArrayList<>();
        mathQuestionRepository = new MathQuestionRepository(questions);
        questions.add(new Question("zxc", "qaz"));
        questions.add(new Question("WDR", "FVC"));
    }
    @Test
    public void add() {
        assertEquals("Вопрос добавлен",mathQuestionRepository.add("QQQzxc", "qazQ"));
        assertEquals("Такой вопрос уже есть!",mathQuestionRepository.add("zxc", "qaz"));
    }

    @Test
    public void remove() {
        assertEquals("Вопрос удален!",mathQuestionRepository.remove("zxc", "qaz"));
        assertEquals("Вопрос не найден",mathQuestionRepository.remove("c", "qz"));
    }

    @Test
    public void getAll() {
        assertEquals(2,mathQuestionRepository.getAll().size());
    }
}