package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
