package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.dto.QuizDTO;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.Quiz;
import com.telusko.quizapp.repository.QuestionDAO;
import com.telusko.quizapp.repository.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

	private final QuestionMapper questionMapper;

	private static final Logger logger = LoggerFactory.getLogger(QuizService.class);

	private final QuizDAO quizDAO;

	private final QuizMapper quizMapper;

	private final QuestionDAO questionDAO;

	@Autowired
	public QuizService(QuestionMapper questionMapper, QuizDAO quizDAO, QuizMapper quizMapper, QuestionDAO questionDAO) {
		this.questionMapper = questionMapper;
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

	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id) {
		try {
			Optional<Quiz> quiz = quizDAO.findById(id);
			List<QuestionDTO> quizQuestions;

			if (quiz.isPresent()) {
				quizQuestions = quiz.get().getQuestions().stream().map(questionMapper::toDTONoAnswer).toList();
			}
			else {
				throw new IllegalArgumentException("Quiz id does not exist");
			}

			return new ResponseEntity<>(quizQuestions, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error("An error occurred while trying to get quiz questions", e);
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
