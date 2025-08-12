package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuizDTO;
import com.telusko.quizapp.model.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper {

	QuizDTO toDTO(Quiz quiz);

	Quiz toEntity(QuizDTO quizDTO);

}
