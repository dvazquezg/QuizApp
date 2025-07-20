package com.telusko.quizapp.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@Table(name = "question")
//public class Question {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "question_title", nullable = false)
//    private String questionTitle;
//
//    @Column(nullable = false)
//    private String option1;
//
//    @Column(nullable = false)
//    private String option2;
//
//    @Column(nullable = false)
//    private String option3;
//
//    @Column(nullable = false)
//    private String option4;
//
//    @Column(name = "right_answer", nullable = false)
//    private String rightAnswer;
//
//    @Column(name = "difficulty_level", nullable = false)
//    private String difficultyLevel;
//
//    @Column(nullable = false)
//    private String category;
//}

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
