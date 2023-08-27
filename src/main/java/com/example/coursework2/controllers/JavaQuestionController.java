package com.example.coursework2.controllers;

import com.example.coursework2.domain.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping(path = "/add")
    public String addQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {
        return questionService.add(question,answer);
    }

    @GetMapping(path = "/remove")
    public String removeQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        return questionService.remove(question,answer);
    }
}
