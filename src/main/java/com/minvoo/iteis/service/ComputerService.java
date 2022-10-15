package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.entity.Computer;

import java.util.List;

public interface ComputerService {
    List<ComputerDto> getAllComputers();
    ComputerDto findById(Long id);
    Computer saveComputer(Computer computer, Long employeeId);
    void deleteById(Long id);
    ComputerDto updateComputer(ComputerDto computerDto, Long id);
}
