package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Optional<Category> findCategoryByName(String categoryName);
}
