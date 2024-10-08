package com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	Map<String, Object> map = new HashMap<>();
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> general() {
		map.put("data", "An exception occure at run time! check your logs");
		return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
