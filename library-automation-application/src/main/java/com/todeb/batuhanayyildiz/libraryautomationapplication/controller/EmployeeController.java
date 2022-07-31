package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.EmployeeDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Employee;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity getAllEmployees(){
        List<Employee> allEmployees= employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Long id){
        Employee byId = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee respEmployee = employeeService.createEmployee(employeeDTO);
        if (respEmployee == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respEmployee);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity deleteEmployee(@RequestParam(name="id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Employee is deleted successfully");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{name}")
    public ResponseEntity updateEmployee(
            @PathVariable String name,
            @RequestBody EmployeeDTO employeeDTO){
        Employee update =employeeService.updateEmployee(name,employeeDTO);
        if(update ==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);


    }

}
