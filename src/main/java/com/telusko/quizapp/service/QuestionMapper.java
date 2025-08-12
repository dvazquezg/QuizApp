package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

	QuestionDTO toDTO(Question question);

	@Mapping(target = "rightAnswer", ignore = true)
	QuestionDTO toDTONoAnswer(Question question);

	Question toEntity(QuestionDTO dto);

}
