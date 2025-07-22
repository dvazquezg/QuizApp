package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.repository.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;

	public List<QuestionDTO> getAllQuestions() {
		return questionDAO.findAll().stream().map(QuestionMapper::toDTO).collect(Collectors.toList());
	}

	public List<QuestionDTO> getQuestionsByCategory(String category) {
		return questionDAO.findByCategory(category).stream().map(QuestionMapper::toDTO).collect(Collectors.toList());
	}

	public String addQuestion(QuestionDTO question) {
		questionDAO.save(QuestionMapper.toEntity(question));
		return "success";
	}

}
