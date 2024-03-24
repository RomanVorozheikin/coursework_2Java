package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.MethodNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MathQuestionServiceImpl implements QuestionService {
    private final Random random;

    public MathQuestionServiceImpl(Random random) {
        this.random = random;
    }

    @Override
    public List<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public String add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public String remove(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        String question = Integer.toString(random.nextInt(900) + 100);
        StringBuilder answer = new StringBuilder(question);
        answer.reverse();
        return new Question(question, answer.toString());
    }
}
