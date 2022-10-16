package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.entity.Mobile;

import java.util.List;
import java.util.Optional;

public interface ComputerService {
    ComputerDto add(ComputerDto computerDto);
    ComputerDto findById(Long id);

    Optional<List<Computer>> findByEmployeeId(Long id);

    List<Computer> findAllByEmployee(EmployeeDto employeeDto);

    List<ComputerDto> findAll();

    void deleteById(Long id);
}
