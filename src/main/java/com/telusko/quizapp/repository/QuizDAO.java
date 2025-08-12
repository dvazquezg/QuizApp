package com.telusko.quizapp.repository;

import com.telusko.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {

}
