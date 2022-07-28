package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.BookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDTO toDto(Book entity);


    Book toEntity(BookDTO dto);

}
