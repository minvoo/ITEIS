package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.exception.EmployeeNotFoundException;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.mapToDto(employees);
    }

    @Override
    public Optional<EmployeeDto> getById(Long id) {

        Optional<Employee> employee = Optional.ofNullable(Optional.of(employeeRepository.getById(id))
                .orElseThrow(() -> new EmployeeNotFoundException("User with id " + id + "doesn't exist")));


        return Optional.ofNullable(EmployeeMapper.mapToDto(employee.get()));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
