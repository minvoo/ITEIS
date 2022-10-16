package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Printer;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PrinterService {
    PrinterDto add(PrinterDto printerDto);
    PrinterDto findById(Long id);

    Optional<List<Printer>> findByEmployeeId(Long id);

    List<Printer> findAllByEmployee(EmployeeDto employeeDto);

    List<PrinterDto> findAll();

    void deleteById(Long id);
}
