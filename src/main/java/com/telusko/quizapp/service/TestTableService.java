package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.TestTableDAO;
import com.telusko.quizapp.model.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableService {

    @Autowired
    private TestTableDAO repository;

    public List<TestTable> getAllEntries() {
        System.out.println(repository.count());
        List<TestTable> list = repository.findAll();
        System.out.println(">>>> list size: " + list.size());
//        for (TestTable t : list) {
//            System.out.println(t.getName());
//        }
        return repository.findAll();
    }

}

