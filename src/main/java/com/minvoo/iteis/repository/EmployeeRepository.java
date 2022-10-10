package com.minvoo.iteis.repository;

import com.minvoo.iteis.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
