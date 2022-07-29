package com.todeb.batuhanayyildiz.libraryautomationapplication.service;



import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.CategoryDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategory(Long id);

    Category createCategory(CategoryDTO categoryDTO);

    Category updateCategory(String categoryName,CategoryDTO categoryDTO);

    boolean deleteCategory(Long categoryId);
}
