package com.example.coursework2.controllers;

import com.example.coursework2.exceptions.MoreThanInServiceException;
import com.example.coursework2.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/exam")
    public Set<String> getQuestions(@RequestParam int amount) throws MoreThanInServiceException {
        return examinerService.getQuestions(amount);
    }
}
