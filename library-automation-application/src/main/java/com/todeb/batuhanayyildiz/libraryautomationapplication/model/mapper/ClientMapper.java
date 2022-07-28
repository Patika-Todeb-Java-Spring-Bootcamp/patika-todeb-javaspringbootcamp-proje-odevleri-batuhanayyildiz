package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ClientDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientDTO toDto(Client entity);


    Client toEntity(ClientDTO dto);
}
