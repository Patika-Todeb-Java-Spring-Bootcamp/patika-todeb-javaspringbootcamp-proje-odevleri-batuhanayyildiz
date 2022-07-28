package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;

import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.CategoryDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.CategoryMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.CategoryRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    @Override
    public Category getCategory(Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Category"));
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper;
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(String categoryName, CategoryDTO categoryDTO){

    }




}
