package com.telusko.quizapp.controller;

import com.telusko.quizapp.dao.TestTableDAO;
import com.telusko.quizapp.model.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestTableController {

    @Autowired
    private TestTableDAO testTableRepository;

    // Get all entries
    @GetMapping
    public List<TestTable> getAllEntries() {
        System.out.println(testTableRepository.count());
        List<TestTable> list = testTableRepository.findAll();
        System.out.println(">>>> list size: " + list.size());
        for (TestTable t : list) {
            System.out.println(t.getName());
        }
        return testTableRepository.findAll();
    }

    // Get entry by name (primary key)
    @GetMapping("/{name}")
    public TestTable getEntryByName(@PathVariable String name) {
        return testTableRepository.findById(name).orElse(null);
    }

    // Create a new entry
    @PostMapping
    public TestTable createEntry(@RequestBody TestTable entry) {
        return testTableRepository.save(entry);
    }

    // Delete entry by name
    @DeleteMapping("/{name}")
    public void deleteEntry(@PathVariable String name) {
        testTableRepository.deleteById(name);
    }
}
