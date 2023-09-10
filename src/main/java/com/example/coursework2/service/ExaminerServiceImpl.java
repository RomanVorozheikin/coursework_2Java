package com.example.coursework2.service;

import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService mathQuestionService;
    private final QuestionService javaQuestionService;


    @Autowired
    public ExaminerServiceImpl(@Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService,
                               @Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService) {
        this.mathQuestionService = mathQuestionService;
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Set<String> getQuestions(int amount) throws MoreThanInServiceException {
        if (amount > mathQuestionService.getAll().size() + javaQuestionService.getAll().size()) {
            throw new MoreThanInServiceException();
        }
        Set<String> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion().getQuestion());
            if (questions.size() < amount) {
                questions.add(mathQuestionService.getRandomQuestion().getQuestion());
            }
        }
        return questions;
    }
}