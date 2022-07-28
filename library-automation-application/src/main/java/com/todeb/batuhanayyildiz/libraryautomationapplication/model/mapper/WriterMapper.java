package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.WriterDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import org.mapstruct.Mapper;

@Mapper
public interface WriterMapper {
    WriterDTO toDto(Writer entity);


    Writer toEntity(WriterDTO dto);
}
