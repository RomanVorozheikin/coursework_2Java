package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final List<Question> questions;

    public JavaQuestionRepository(List<Question>questions) {
        this.questions = questions;
    }

    @PostConstruct
    public void init() {
        questions.add(new Question("Символьный тип переменной", "char"));
        questions.add(new Question("С какого индекса начинается нумерация массива?", "С нуля"));
        questions.add(new Question("Ключевое слово для создания объекта", "new"));
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
    public List<Question> getAll() {
        return questions;
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

    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
