package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long expenseId;
	private String name;
	private Long category;
	private int amount;
	private String description;
}
