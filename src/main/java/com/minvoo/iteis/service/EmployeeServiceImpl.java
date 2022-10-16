package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.*;
import com.minvoo.iteis.exception.EmployeeNotFoundException;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.mapper.PrinterMapper;
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
import java.util.Set;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PrinterService printerService;

    @Autowired
    private MobileService mobileService;
    @Autowired
    private ComputerService computerService;

    /**
     * Finds all employes (as DTO objects) in the database
     * @return List<EmployeeDto>
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.mapToDto(employees);
    }

    /**
     * Finds entity in database by Employee ID.<br>
     * Returns Optional in case of getting null from database.
     * @param id - primary key value of Employee Entity
     * @return EmployeeDto
     */
    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("User with id " + id + "doesn't exist"));
        return EmployeeMapper.mapToDto(employee);
    }

    /**
     * Adds employee to database
     * @param employee - object to add to database
     * @return Employee
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        employee.setRole(Role.USER);
        employee.setUuid(UuidGenerator.generateUuid());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.saveAndFlush(employee);
    }

    /**
     * Updates existing employee in database.
     * Additionally encode password with BCryptEncoder
     * @param employeeDto - object to get new fields values from
     * @param id - id of employee to change fields  values
     * @return EmployeeDto
     */
    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
        Employee employee = employeeRepository.getById(id);
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setPosition(employeeDto.getPosition());
        employee.setLastName(employeeDto.getLastName());

        Employee employeeUpdated = employeeRepository.saveAndFlush(employee);
        log.info(employeeUpdated.toString());
        return EmployeeMapper.mapToDto(employeeUpdated);
    }

    /**
     * Changes password of Employee
     * @param employeeDto - object retrieved from html form with new password
     * @param id - primary key of existing Employee in database
     * @return
     */
    @Override
    public EmployeeDto changePassword(EmployeeDto employeeDto, Long id) {
        Employee emp = employeeRepository.getById(id);
        Employee empUpdate = emp.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        Employee empInDb = employeeRepository.saveAndFlush(empUpdate);
        return EmployeeMapper.mapToDto(empInDb);

    }

    /**
     * Deletes entity from db
     * @param id - existing Employee ID in db
     */
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    /**
     * Deletes entity from db
     * Also sets all foreign keys to null
     * @param id - existing Employee ID in db
     * @param authentication - value for check if user is authenticated to run method
     */
    @Override
    public void deleteById(Long id, Authentication authentication) {
        String empName = authentication.getName();
        Optional<Employee> employeeOptional = findByUsername(empName);
        Employee employee = employeeOptional.get();
        if (employee.getId() == id) {
            return;
        }
        Employee employeeToDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("User with id " + id + "doesn't exist"));
        EmployeeDto employeeToDeleteDto = EmployeeMapper.mapToDto(employeeToDelete);
        List<Printer> allEmployeesPrinters = printerService.findAllByEmployee(employeeToDeleteDto);
        List<Mobile> allEmployeesMobiles = mobileService.findAllByEmployee(employeeToDeleteDto);
        List<Computer> allEmployeesComputers = computerService.findAllByEmployee(employeeToDeleteDto);


        if (!allEmployeesPrinters.isEmpty()) {
            allEmployeesPrinters.stream().forEach(e -> e.setEmployee(null));
        }
        if (!allEmployeesMobiles.isEmpty()) {
            allEmployeesMobiles.stream().forEach(e -> e.setEmployee(null));
        }
        if (!allEmployeesComputers.isEmpty()) {
            allEmployeesComputers.stream().forEach(e -> e.setEmployee(null));
        }
        deleteById(id);
    }

    /**
     * Finds employee by his username
     * @param username - username field value in database
     * @return Optional<Employee>
     */
    @Override
    public Optional<Employee> findByUsername(String username) {
        return employeeRepository.findByUsername(username);

    }

    /**
     * Changes role of selected Employee.
     * If user has Admin role, method changes it to User and vice versa
     * Current Admin can't change his role in case of security.
     * @param id - id of user to change his role
     * @returns void
     */
    @Override
    public void changeRole(Long id) {
        EmployeeDto employee = findById(id);
        String employeeRole = employee.getRole().name();
        if (employeeRole == "USER") {
            employee.setRole(Role.ADMIN);
        } else {
            employee.setRole(Role.USER);
        }
        Employee employeeUpdated = EmployeeMapper.mapToEntity(employee);
        employeeRepository.saveAndFlush(employeeUpdated);
    }
}
