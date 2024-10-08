package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Expense;
import com.repositories.ExpenseRepository;

@Service
public class ExpenseServices {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Optional<Expense> create(Expense expense) {
		return Optional.of(expenseRepository.save(expense));
	}
	
	
	public List<Expense> getExpenses() {
		return expenseRepository.findAll();
	}
	
	
	public boolean deleteExpenseById(Long expenseId) {
		try {
			expenseRepository.deleteById(expenseId);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
