package com.minvoo.iteis.service;


import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Employee;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto findById(Long id);

    Employee saveEmployee(Employee employee);

    EmployeeDto changePassword(EmployeeDto employeeDto, Long id);

    void deleteById(Long id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);

    Optional<Employee> findByUsername(String username);

    void changeRole(Long id);

    void deleteById(Long id, Authentication authentication);

}
