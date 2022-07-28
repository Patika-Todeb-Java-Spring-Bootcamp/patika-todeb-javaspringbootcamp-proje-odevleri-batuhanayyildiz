package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ReservedBookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.ReservedBook;
import org.mapstruct.Mapper;

@Mapper
public interface ReservedBookMapper {
    ReservedBookDTO toDto(ReservedBook entity);


    ReservedBook toEntity(ReservedBookDTO dto);
}
