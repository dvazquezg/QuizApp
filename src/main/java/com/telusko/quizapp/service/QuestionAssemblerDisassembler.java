package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.model.Question;

public class QuestionAssemblerDisassembler {

	public static QuestionDTO toDTO(Question question) {
		return QuestionDTO.builder()
			.id(question.getId())
			.questionTitle(question.getQuestionTitle())
			.option1(question.getOption1())
			.option2(question.getOption2())
			.option3(question.getOption3())
			.option4(question.getOption4())
			.rightAnswer(question.getRightAnswer())
			.difficultyLevel(question.getDifficultyLevel())
			.category(question.getCategory())
			.build();
		// return null;
	}

	public static Question toEntity(QuestionDTO dto) {
		if (dto == null)
			return null;
		Question question = new Question();
		// question.setId(dto.getId()); // usually id is null for new records
		question.setQuestionTitle(dto.getQuestionTitle());
		question.setOption1(dto.getOption1());
		question.setOption2(dto.getOption2());
		question.setOption3(dto.getOption3());
		question.setOption4(dto.getOption4());
		question.setRightAnswer(dto.getRightAnswer());
		question.setDifficultyLevel(dto.getDifficultyLevel());
		question.setCategory(dto.getCategory());
		return question;
		// return null;
	}

}