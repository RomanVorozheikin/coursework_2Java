package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final List<Question> mathQuestion;

    public MathQuestionRepository(List<Question> mathQuestion) {
        this.mathQuestion = mathQuestion;
    }
    @Override
    public String add(String question, String answer) {
        Question q1 = new Question(question, answer);
        Set<String> questionsMath = mathQuestion.stream()
                .map(Question::getQuestion)
                .collect(Collectors.toSet());
        if (questionsMath.contains(q1.getQuestion())) {
            return "Такой вопрос уже есть!";
        }
        mathQuestion.add(q1);
        return "Вопрос добавлен";
    }

    @Override
    public List<Question> getAll() {
        return mathQuestion;
    }

    @Override
    public String remove(String question, String answer) {
        Question q2 = new Question(question, answer);
        if (mathQuestion.contains(q2)) {
            mathQuestion.remove(q2);
            return "Вопрос удален!";
        }
        return "Вопрос не найден";
    }
    public Question getRandomQuestion() {
        Random random = new Random();
        return mathQuestion.get(random.nextInt(mathQuestion.size()));
    }
}
