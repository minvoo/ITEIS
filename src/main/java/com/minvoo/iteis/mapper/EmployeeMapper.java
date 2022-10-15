package com.minvoo.iteis.mapper;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {
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
//                .computers(employee.getComputers())
                .build();
    }
    public static List<EmployeeDto> mapToDto(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::mapToDto)
                .collect(Collectors.toList());
    }
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
//                .computers(employee.getComputers())
    }
}
