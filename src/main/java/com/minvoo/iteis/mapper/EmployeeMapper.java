package com.minvoo.iteis.mapper;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    /**
     * Converts entity to DTO object
     * @param employee - entity to convert it to dto
     * @return ComputerDto
     */
    public static EmployeeDto mapToDto(Employee employee) {
        return new EmployeeDto().toBuilder()
                .id(employee.getId())
                .uuid(employee.getUuid())
                .username(employee.getUsername())
                .password(employee.getPassword())
                .email(employee.getEmail())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .role(employee.getRole())
                .createTime(employee.getCreateTime())
                .position(employee.getPosition())
//                .employees(employee.getComputers())
                .build();
    }

    /**
     * Converts entity to dto object
     * @param employees - list of entity objects
     * @return List<ComputerDto>
     */
    public static List<EmployeeDto> mapToDto(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    /**
     * Converts dto to entity obbject
     * @param employeeDto - dto to convert into entity
     * @return Computer
     */
    public static Employee mapToEntity(EmployeeDto employee) {
        return new Employee()
                .setId(employee.getId())
                .setUuid(employee.getUuid())
                .setUsername(employee.getUsername())
                .setPassword(employee.getPassword())
                .setEmail(employee.getEmail())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setRole(employee.getRole())
                .setCreateTime(employee.getCreateTime())
                .setPosition(employee.getPosition());
//                .employees(employee.getComputers())
    }
}
