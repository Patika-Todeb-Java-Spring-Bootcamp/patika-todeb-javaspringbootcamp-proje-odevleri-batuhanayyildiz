package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;

import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.EmployeeDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Employee;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.EmployeeMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.EmployeeRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    private static final EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id){
        Optional<Employee> byId = employeeRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Employee"));
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = EMPLOYEE_MAPPER.toEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String employeeName,EmployeeDTO employeeDTO) {
        Optional<Employee> employeeByName = employeeRepository.findEmployeeByName(employeeName);
        if (!employeeByName.isPresent()) {
            throw new NotFoundException("Employee");
        }
        Employee updatedEmployee = employeeByName.get();
        if (!ObjectUtils.isEmpty(employeeDTO.getName())){
            updatedEmployee.setName(employeeDTO.getName());
        }
        if (!ObjectUtils.isEmpty(employeeDTO.getSurname())){
            updatedEmployee.setSurname(employeeDTO.getSurname());
        }

        if (!ObjectUtils.isEmpty(employeeDTO.getPhoneNumber())){
            updatedEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
        }

        if (!ObjectUtils.isEmpty(employeeDTO.getEmail())){
            updatedEmployee.setEmail(employeeDTO.getEmail());
        }

        if (!ObjectUtils.isEmpty(employeeDTO.getAddress())){
            updatedEmployee.setAddress(employeeDTO.getAddress());
        }
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public boolean deleteEmployee(Long employeeId){
        Employee employee=getEmployeeById(employeeId);
        if(!ObjectUtils.isEmpty(employee)){
            employeeRepository.delete(getEmployeeById(employeeId));
            return true;
        }
        else throw new NotFoundException("id"+""+employeeId.toString());

    }

}
