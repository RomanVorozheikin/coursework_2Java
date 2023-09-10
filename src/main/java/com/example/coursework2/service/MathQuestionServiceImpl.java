package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.repository.MathQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class MathQuestionServiceImpl implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    @Autowired
    public MathQuestionServiceImpl(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @PostConstruct
    public void init() {
        mathQuestionRepository.add("5+3=", "8");
        mathQuestionRepository.add("10/2=", "5");
        mathQuestionRepository.add("20*5=", "100");
    }
    @Override
    public List<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public String add(String question, String answer) {
        return mathQuestionRepository.add(question, answer);
    }

    @Override
    public String remove(String question, String answer) {
        return mathQuestionRepository.remove(question, answer);
    }

    @Override
    public Question getRandomQuestion() {
        return mathQuestionRepository.getRandomQuestion();
    }
}
