package com.telusko.quizapp.service;

import com.telusko.quizapp.dto.QuestionDTO;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.repository.QuestionDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    private QuestionDAO questionDAO;

    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private QuestionService questionService;

    private Question question;
    private QuestionDTO questionDTO;

    @BeforeEach
    void setup() {
        question = new Question();
        question.setId(1);
        question.setQuestionTitle("What is Java?");
        question.setOption1("Programming Language");
        question.setOption2("Coffee");
        question.setOption3("Island");
        question.setOption4("Car");
        question.setRightAnswer("Programming Language");
        question.setDifficultyLevel("Easy");
        question.setCategory("Java");

        questionDTO = QuestionDTO.builder()
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

    @Test
    void testGetAllQuestions() {
        when(questionDAO.findAll()).thenReturn(Arrays.asList(question));
        when(questionMapper.toDTO(question)).thenReturn(questionDTO);

        List<QuestionDTO> result = questionService.getAllQuestions();

        assertEquals(1, result.size());
        assertEquals("What is Java?", result.get(0).getQuestionTitle());

        // ensures your code follows the correct interaction pattern
        verify(questionDAO, times(1)).findAll();
        verify(questionMapper, times(1)).toDTO(question);
    }

    @Test
    void testGetQuestionsByCategory() {
        when(questionDAO.findByCategory("Java")).thenReturn(List.of(question));
        when(questionMapper.toDTO(question)).thenReturn(questionDTO);

        List<QuestionDTO> result = questionService.getQuestionsByCategory("Java");

        assertEquals(1, result.size());
        assertEquals("Java", result.get(0).getCategory());

        verify(questionDAO).findByCategory("Java");
        verify(questionMapper).toDTO(question);
    }

    @Test
    void testAddQuestion() {
        when(questionMapper.toEntity(questionDTO)).thenReturn(question);

        String result = questionService.addQuestion(questionDTO);

        assertEquals("success", result);
        verify(questionDAO).save(question);
    }

    @Test
    void testAddQuestionTwo() {
        // creating a mock manually
        QuestionMapper questionMapper2 = Mockito.mock(QuestionMapper.class);
        QuestionDAO questionDAO2 = Mockito.mock(QuestionDAO.class);
        QuestionService questionService2 = new QuestionService(questionDAO2, questionMapper2);

        when(questionMapper2.toEntity(questionDTO)).thenReturn(question);

        String result = questionService2.addQuestion(questionDTO);

        assertEquals("success", result);
        verify(questionDAO2).save(question);
    }
}

