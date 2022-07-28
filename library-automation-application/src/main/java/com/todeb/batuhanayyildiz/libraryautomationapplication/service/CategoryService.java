package com.todeb.batuhanayyildiz.libraryautomationapplication.service;



import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategory(Long id);

    Category createCategory(Category category);

    Category updateCategory(Category category);

    boolean deleteCategory(Long categoryId);
}
