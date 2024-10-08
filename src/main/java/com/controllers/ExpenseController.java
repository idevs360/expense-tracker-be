package com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Expense;
import com.services.ExpenseServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseServices expenseServices;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Expense expense) {
		
		try {
			return new ResponseEntity(expenseServices.create(expense), HttpStatus.OK);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getExpenseList() {
		
		try {
			return new ResponseEntity(expenseServices.getExpenses(), HttpStatus.OK);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/delete")
	public boolean deleteExpense(@RequestBody Map<String, String> map) {
		try {
			expenseServices.deleteExpenseById(Long.valueOf(map.get("expenseId")));
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	

}
