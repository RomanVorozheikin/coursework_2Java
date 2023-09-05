package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<String> getQuestions(int amount) throws MoreThanInServiceException {
        if (questionService.getAll().size() < amount) {
            throw new MoreThanInServiceException();
        }
        Set<String> questions = new HashSet<>();
        for (int i = 1; i <= amount; i++) {
            Question question = questionService.getRandomQuestion();
            if (questions.contains(question.getQuestion())) {
                amount++;
            }
            questions.add(question.getQuestion());
        }
        return questions;
    }
}