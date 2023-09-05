package com.example.coursework2.service;
import com.example.coursework2.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final List<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new ArrayList<>();
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }


    @Override
    public String add(String question, String answer) {
        Question q = new Question(question, answer);
        Set<String> setQuestion = questions.stream()
                .map(Question::getQuestion)
                .collect(Collectors.toSet());
        if (setQuestion.contains(question)) {
            return "Такой вопрос уже есть";
        }
        questions.add(q);
        return "Вопрос добавлен";
    }

    @Override
    public String remove(String question, String answer) {
        Question q = new Question(question, answer);
        if (questions.contains(q)) {
            questions.remove(q);
            return "Вопрос удален!";
        }
        return "Вопрос не найден!";
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}

