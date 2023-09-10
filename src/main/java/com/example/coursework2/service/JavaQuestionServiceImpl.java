package com.example.coursework2.service;
import com.example.coursework2.domain.Question;
import com.example.coursework2.repository.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;

    @Autowired
    public JavaQuestionServiceImpl(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public String add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }
    @PostConstruct
    public void init() {
        javaQuestionRepository.add("Символьный тип переменной", "char");
        javaQuestionRepository.add("С какого индекса начинается нумерация массива?", "С нуля");
        javaQuestionRepository.add("Ключевое слово для создания объекта", "new");
    }

    @Override
    public List<Question> getAll() {
        return javaQuestionRepository.getAll();
    }


    @Override
    public String remove(String question, String answer) {
        return javaQuestionRepository.remove(question, answer);
    }

    @Override
    public Question getRandomQuestion() {
        return javaQuestionRepository.getRandomQuestion();
    }
}

