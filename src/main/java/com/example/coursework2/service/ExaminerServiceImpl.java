package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.MoreThanInServiceException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<String> getQuestions(int amount) throws MoreThanInServiceException {
        Set<String> questions = questionService.getAll().stream()
                .map(Question::getQuestion)
                .limit(amount)
                .collect(Collectors.toSet());
        if (questions.size() < amount) {
            throw new MoreThanInServiceException();
        }
        return questions;
    }
}