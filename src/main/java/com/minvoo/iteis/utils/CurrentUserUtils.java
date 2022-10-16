package com.minvoo.iteis.utils;

import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CurrentUserUtils {

    private EmployeeService employeeService;


    @Autowired
    public CurrentUserUtils(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Gets current logged in user as entity.
     * @param authentication - authentiction from SecurityContextHolder
     * @return
     */
    public Employee getCurrentUser(Authentication authentication) {
        Optional<Employee> employeeOptional = employeeService.findByUsername(authentication.getName());
        Employee employee = employeeOptional.get();
        return employee;
    }
}
