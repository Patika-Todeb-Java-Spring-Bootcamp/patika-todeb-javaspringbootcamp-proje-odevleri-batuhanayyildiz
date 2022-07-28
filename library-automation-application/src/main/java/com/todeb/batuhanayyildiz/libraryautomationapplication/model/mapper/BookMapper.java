package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.BookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    public BookDTO toDto(Book entity);


    public Book toEntity(BookDTO dto);

}
