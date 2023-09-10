package com.example.coursework2.service;

import com.example.coursework2.domain.Question;

import java.util.List;

public interface QuestionService {
    String add(String question, String answer);
    List<Question> getAll();
    String remove(String question, String answer);
    Question getRandomQuestion();
}
