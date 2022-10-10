package com.minvoo.iteis.service;


import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    Optional<EmployeeDto> getById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteById(Long id);
}
