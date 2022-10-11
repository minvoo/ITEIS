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
    public EmployeeDto findById(Long id) {

         Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("User with id " + id + "doesn't exist"));


        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {

        Employee employee = employeeRepository.getById(id);

        employee.setPassword(employeeDto.getPassword());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setPosition(employeeDto.getPosition());
        employee.setLastName(employeeDto.getLastName());

        employeeRepository.saveAndFlush(employee);
        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
