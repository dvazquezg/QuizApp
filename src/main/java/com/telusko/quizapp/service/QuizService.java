package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuizDTO;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.repository.QuestionDAO;
import com.telusko.quizapp.repository.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class QuizService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	private final QuizDAO quizDAO;

	private final QuizMapper quizMapper;

	private final QuestionDAO questionDAO;

	@Autowired
	public QuizService(QuizDAO quizDAO, QuizMapper quizMapper, QuestionDAO questionDAO) {
		this.quizDAO = quizDAO;
		this.quizMapper = quizMapper;
		this.questionDAO = questionDAO;
	}

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		try {
			QuizDTO newQuiz = new QuizDTO();
			newQuiz.setQuizTitle(title);
			List<Question> questionList = questionDAO.findRandomQuestionsByCategory(category, numQ);
			newQuiz.setQuestions(questionList);
			quizDAO.save(quizMapper.toEntity(newQuiz));
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}
		catch (Exception e) {
			logger.error("An error occurred while trying to add new quiz", e);
		}

		return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
	}

}
