package com.telusko.quizapp.controller;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

	private final QuestionService questionService;

	@Autowired
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@GetMapping("allQuestions")
	public List<QuestionDTO> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("category/{category}")
	public List<QuestionDTO> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}

	@PostMapping("add")
	public String addQuestion(@RequestBody QuestionDTO question) {
		return questionService.addQuestion(question);
	}

}
