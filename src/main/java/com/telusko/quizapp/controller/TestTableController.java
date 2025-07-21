package com.telusko.quizapp.controller;

import com.telusko.quizapp.model.TestTable;
import com.telusko.quizapp.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestTableController {

	@Autowired
	TestTableService testTableService;

	// Get all entries
	@GetMapping("allNames")
	public List<TestTable> getAllEntries() {
		return testTableService.getAllEntries();
	}

	// Get entry by name (primary key)
	@GetMapping("/{name}")
	public TestTable getEntryByName(@PathVariable String name) {
		return testTableService.getEntriesByName(name);
	}

	@GetMapping("/search")
	public List<TestTable> findByNameContainingIgnoreCase(@RequestParam String keyword) {
		return testTableService.findByNameContainingIgnoreCase(keyword);
	}

	// Create a new entry
	@PostMapping("addName")
	public TestTable createEntry(@RequestBody TestTable entry) {
		return testTableService.createEntry(entry);
	}

	// Delete entry by name
	@DeleteMapping("/{name}")
	public void deleteEntry(@PathVariable String name) {
		testTableService.deleteEntry(name);
	}

}
