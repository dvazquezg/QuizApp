package com.telusko.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TestTable {

	@Id
	private String name;

}