package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.CategoryDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/all")
    public ResponseEntity getAllCategorys() {
        List<Category> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") Long id) {
        Category byId = categoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewCategory(@RequestBody CategoryDTO categoryDTO) {
        Category respCategory = categoryService.createCategory(categoryDTO);
        if (respCategory == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respCategory);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestParam(name = "id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Category is deleted successfully");
    }

    @PutMapping("/{name}")
    public ResponseEntity updateCategory(
            @PathVariable String name,
            @RequestBody CategoryDTO categoryDTO) {
        Category update = categoryService.updateCategory(name, categoryDTO);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
}
