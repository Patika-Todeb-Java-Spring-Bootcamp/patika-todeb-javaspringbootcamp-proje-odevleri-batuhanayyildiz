package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.CategoryDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO toDto(Category entity);


    Category toEntity(CategoryDTO dto);
}
