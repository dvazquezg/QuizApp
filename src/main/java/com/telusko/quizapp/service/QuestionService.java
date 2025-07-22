package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.repository.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

	private final QuestionDAO questionDAO;

	private final QuestionMapper questionMapper;

	@Autowired
	public QuestionService(QuestionDAO questionDAO, QuestionMapper questionMapper) {
		this.questionDAO = questionDAO;
		this.questionMapper = questionMapper;
	}

	public List<QuestionDTO> getAllQuestions() {
		return questionDAO.findAll().stream().map(questionMapper::toDTO).collect(Collectors.toList());
	}

	public List<QuestionDTO> getQuestionsByCategory(String category) {
		return questionDAO.findByCategory(category).stream().map(questionMapper::toDTO).collect(Collectors.toList());
	}

	public String addQuestion(QuestionDTO question) {
		questionDAO.save(questionMapper.toEntity(question));
		return "success";
	}

}
