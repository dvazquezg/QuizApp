package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.model.Question;

public class QuestionTestFactory {

	public static Question createSampleQuestion() {
		return Question.builder()
			.id(1)
			.questionTitle("What is Java?")
			.option1("Programming Language")
			.option2("Coffee")
			.option3("Island")
			.option4("Car")
			.rightAnswer("Programming Language")
			.difficultyLevel("Easy")
			.category("Java")
			.build();
	}

	// Optionally add more factory methods
	public static Question createQuestionWithCategory(String category) {
		return Question.builder()
			.questionTitle("Sample Question")
			.option1("A")
			.option2("B")
			.option3("C")
			.option4("D")
			.rightAnswer("A")
			.difficultyLevel("Medium")
			.category(category)
			.build();
	}

	public static QuestionDTO createSampleQuestionDTO() {
		return QuestionDTO.builder()
			.id(1)
			.questionTitle("What is Java?")
			.option1("Programming Language")
			.option2("Coffee")
			.option3("Island")
			.option4("Car")
			.rightAnswer("Programming Language")
			.difficultyLevel("Easy")
			.category("Java")
			.build();
	}

	// Optional: Overloads for customization
	public static QuestionDTO customQuestionDTO(String title, String category) {
		return QuestionDTO.builder()
			.questionTitle(title)
			.option1("Option 1")
			.option2("Option 2")
			.option3("Option 3")
			.option4("Option 4")
			.rightAnswer("Option 1")
			.difficultyLevel("Medium")
			.category(category)
			.build();
	}

}
