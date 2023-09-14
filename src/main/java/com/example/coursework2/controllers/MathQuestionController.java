package com.example.coursework2.controllers;

import com.example.coursework2.domain.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    @Autowired
    public MathQuestionController(@Qualifier("mathQuestionServiceImpl") QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getMathQuestionList() {
        return questionService.getAll();
    }
    @GetMapping("/add")
    public String addMathQuestion(@RequestParam String question,
                                  @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String removeMathQuestion(@RequestParam String question,
                                     @RequestParam String answer) {
        return questionService.remove(question, answer);
    }
}
