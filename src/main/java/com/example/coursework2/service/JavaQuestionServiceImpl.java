package com.example.coursework2.service;
import com.example.coursework2.domain.Question;
import com.example.coursework2.repository.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;

    @Autowired
    public JavaQuestionServiceImpl(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question getRandomQuestion() {
        return javaQuestionRepository.getRandomQuestion();
    }

    @Override
    public String add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public List<Question> getAll() {
        return javaQuestionRepository.getAll();
    }


    @Override
    public String remove(String question, String answer) {
        return javaQuestionRepository.remove(question, answer);
    }
}

