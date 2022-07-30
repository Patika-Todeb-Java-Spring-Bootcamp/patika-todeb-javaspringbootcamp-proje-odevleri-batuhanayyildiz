package com.todeb.batuhanayyildiz.libraryautomationapplication.service;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.EmployeeDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Employee;


import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee createEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(String employeeName, EmployeeDTO employeeDTO);

    boolean deleteEmployee(Long id);
}
