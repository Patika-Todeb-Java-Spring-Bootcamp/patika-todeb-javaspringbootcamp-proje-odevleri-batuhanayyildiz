package com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.EmployeeDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    EmployeeDTO toDto(Employee entity);


    Employee toEntity(EmployeeDTO dto);
}
