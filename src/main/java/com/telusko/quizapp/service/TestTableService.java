package com.telusko.quizapp.service;

import com.telusko.quizapp.repository.TestTableDAO;
import com.telusko.quizapp.model.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableService {

	@Autowired
	TestTableDAO testTableDAO;

	public List<TestTable> getAllEntries() {
		return testTableDAO.findAll();
	}

	public TestTable getEntriesByName(String name) {
		return testTableDAO.findById(name).orElse(null);
	}

	public List<TestTable> findByNameContainingIgnoreCase(String keyword) {
		return testTableDAO.findByNameContainingIgnoreCase(keyword);
	}

	public TestTable createEntry(TestTable entry) {
		return testTableDAO.save(entry);
	}

	public void deleteEntry(String name) {
		testTableDAO.deleteById(name);
	}

}
