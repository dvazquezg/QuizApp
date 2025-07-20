package com.telusko.quizapp.dao;

import com.telusko.quizapp.model.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestTableDAO extends JpaRepository<TestTable, String> {

    // Optional: You can define custom queries here if needed
    List<TestTable> findByNameContainingIgnoreCase(String keyword);
}