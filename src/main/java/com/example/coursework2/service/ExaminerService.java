package com.example.coursework2.service;

import com.example.coursework2.exceptions.MoreThanInServiceException;

import java.util.Set;

public interface ExaminerService {
    Set<String> getQuestions(int amount) throws MoreThanInServiceException;
}