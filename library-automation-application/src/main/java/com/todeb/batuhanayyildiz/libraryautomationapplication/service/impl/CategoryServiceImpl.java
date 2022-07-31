package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;

import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.CustomJwtException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.CategoryDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.CategoryMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.CategoryRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    private static final CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Category"));
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO){
        if (!categoryRepository.existsByName(categoryDTO.getName())){
            Category category = CATEGORY_MAPPER.toEntity(categoryDTO);
            return categoryRepository.save(category);
        }
        else {
            throw new CustomJwtException("There is a book with same name.", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public Category updateCategory(String categoryName,CategoryDTO categoryDTO) {
        Optional<Category> categoryByName = categoryRepository.findCategoryByName(categoryName);
        if (!categoryByName.isPresent()) {
            throw new NotFoundException("Category");
        }
        Category updatedCategory = categoryByName.get();
        if (!ObjectUtils.isEmpty(categoryDTO.getName())) {
            updatedCategory.setName(categoryDTO.getName());
        }
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public boolean deleteCategory(Long categoryId){
        Category category=getCategoryById(categoryId);
        if(!ObjectUtils.isEmpty(category)){
            categoryRepository.delete(getCategoryById(categoryId));
            return true;
        }
        else throw new NotFoundException("id"+""+categoryId.toString());

    }







}
