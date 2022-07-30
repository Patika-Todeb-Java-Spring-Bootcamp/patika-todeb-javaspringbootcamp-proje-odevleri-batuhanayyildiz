package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByName(String employeeName);
}
