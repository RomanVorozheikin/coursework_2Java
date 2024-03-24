package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;

import java.util.List;

public interface QuestionRepository {
    String add(String question, String answer);
    List<Question> getAll();
    String remove(String question, String answer);
}
