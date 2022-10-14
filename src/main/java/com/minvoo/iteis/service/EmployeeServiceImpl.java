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
import org.springframework.security.core.Authentication;
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
        log.info("Employee before change" + employee.toString());
        log.info("Employee password before " + employee.getPassword());
        log.info("DTO password " + employeeDto.getPassword());
        employee.setPassword(employeeDto.getPassword());
        log.info("Employee password after " + employee.getPassword());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setPosition(employeeDto.getPosition());
        employee.setLastName(employeeDto.getLastName());
        employee.setPassword(employeeDto.getPassword());
        log.info("Employee after change" + employee.toString());

        Employee employeeUpdated = employeeRepository.saveAndFlush(employee);
        log.info(employeeUpdated.toString());
        return EmployeeMapper.mapToDto(employeeUpdated);
    }

    @Override
    public EmployeeDto changePassword(EmployeeDto employeeDto, Long id) {

        Employee emp = employeeRepository.getById(id);

        Employee empUpdate = emp.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        Employee empInDb = employeeRepository.saveAndFlush(empUpdate);
        return EmployeeMapper.mapToDto(empInDb);

    }
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteById(Long id, Authentication authentication) {
        String empName = authentication.getName();
        Optional<Employee> employeeOptional = findByUsername(empName);
        Employee employee = employeeOptional.get();

        if (employee.getId() != id) {
            deleteById(id);
        }
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
