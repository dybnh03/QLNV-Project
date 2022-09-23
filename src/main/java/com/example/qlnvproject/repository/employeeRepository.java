package com.example.qlnvproject.repository;

import com.example.qlnvproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Employee, Long> {
}
