package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.model.Question;

public class QuestionAssemblerDisassembler {

	public static QuestionDTO toDTO(Question question) {
		if (question == null) {
			return null;
		}
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
	}

	public static Question toEntity(QuestionDTO dto) {
		if (dto == null) {
			return null;
		}
		return Question.builder()
			// Skip id for inserting a new record (JPA will auto-generate it)
			.questionTitle(dto.getQuestionTitle())
			.option1(dto.getOption1())
			.option2(dto.getOption2())
			.option3(dto.getOption3())
			.option4(dto.getOption4())
			.rightAnswer(dto.getRightAnswer())
			.difficultyLevel(dto.getDifficultyLevel())
			.category(dto.getCategory())
			.build();
	}

}