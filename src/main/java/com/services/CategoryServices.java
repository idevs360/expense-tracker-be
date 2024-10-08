package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Category;
import com.repositories.CategoryRepository;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<Category> create(Category category) {
		
		return Optional.of(categoryRepository.save(category));
	}
	
	public List<Category> getCategories() {
		
		return categoryRepository.findAll();
	}
	
	
	public boolean deleteCategory(Long catId) {
		
		try {
			categoryRepository.deleteById(catId);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
