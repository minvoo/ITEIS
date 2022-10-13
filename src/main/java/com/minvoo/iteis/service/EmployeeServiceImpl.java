package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Role;
import com.minvoo.iteis.exception.EmployeeNotFoundException;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.repository.EmployeeRepository;
import com.minvoo.iteis.utils.UuidGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.mapToDto(employees);
    }

    @Override
    public EmployeeDto findById(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("User with id " + id + "doesn't exist"));


        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        employee.setRole(Role.USER);
        employee.setUuid(UuidGenerator.generateUuid());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
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

    @Override
    public Optional<Employee> findByUsername(String username) {

        return employeeRepository.findByUsername(username);

    }

    @Override
    public void changeRole(Long id) {

        EmployeeDto employee = findById(id);
        String employeeRole = employee.getRole().name();

        if (employeeRole == "USER") {
            employee.setRole(Role.ADMIN);
        } else {
            employee.setRole(Role.USER);
        }
        log.info("User role changed to: " + employee.getRole().name());
        Employee employeeUpdated = EmployeeMapper.mapToEntity(employee);
        employeeRepository.saveAndFlush(employeeUpdated);
        log.info("User" + employeeUpdated.toString());

    }

    @Override
    public Optional<Employee> findByUuid(String uuid) {
        return employeeRepository.findByUuid(uuid);
    }
}