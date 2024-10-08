package com.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Category;
import com.services.CategoryServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/category")
public class CategoryContoller {

	@Autowired
	private CategoryServices categoryServices;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Category newCategory) 
	{
		Map<String, Object> map = new HashMap<>();
		
		try {
			
			Optional<Category> container = categoryServices.create(newCategory);
			if (container.isPresent()) {
				
				map.put("data", container.get());
				return new ResponseEntity(map, HttpStatus.OK);
				
			} else {
				map.put("data", "");
				return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			map.put("data", "Something went wrong!");
			return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getCategories() {
	    Map<String, Object> map = new HashMap<>();
	    
	    try {
	        List<Category> container = categoryServices.getCategories();
	        if (!container.isEmpty()) {
	            map.put("data", container); // Return the list in "data"
	            return new ResponseEntity<>(map, HttpStatus.OK); // HttpStatus OK
	        } else {
	            map.put("data", new ArrayList<>()); // Return an empty array instead of an empty string
	            return new ResponseEntity<>(map, HttpStatus.OK); // Return OK with empty data
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put("data", "Something went wrong!");
	        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	@PostMapping("/delete")
	public boolean deleteCategory(@RequestBody Map<String, String> payload) {
	    try {
	        String categoryId = payload.get("categoryId"); // Extract categoryId from the request body
	        System.out.println("Category ID: " + categoryId);
	        
	        // Convert to Long and call your service
	        return categoryServices.deleteCategory(Long.valueOf(categoryId));
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	

	
}
