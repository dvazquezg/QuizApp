package com.telusko.quizapp.dto;

import com.telusko.quizapp.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {

	private Integer id;

	private String quizTitle;

	private List<Question> questions;

}
