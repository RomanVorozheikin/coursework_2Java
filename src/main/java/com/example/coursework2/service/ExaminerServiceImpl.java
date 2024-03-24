package com.example.coursework2.service;

import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl")QuestionService javaQuestionService,
                               @Qualifier("mathQuestionServiceImpl")QuestionService mathQuestionService) {
        questionServices = new ArrayList<>();
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }

    @Override
    public Set<String> getQuestions(int amount) throws MoreThanInServiceException {
        if (amount > questionServices.get(0).getAll().size()*2) {
            throw new MoreThanInServiceException();
        }
        Set<String> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionServices.get(0).getRandomQuestion().getQuestion());
            if (questions.size() < amount) {
                questions.add(questionServices.get(1).getRandomQuestion().getQuestion());
            }
        }
        return questions;
    }
}