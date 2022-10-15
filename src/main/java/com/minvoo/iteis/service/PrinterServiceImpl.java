package com.minvoo.iteis.service;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.mapper.PrinterMapper;
import com.minvoo.iteis.repository.PrinterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PrinterServiceImpl implements PrinterService {

    @Autowired
    PrinterRepository printerRepository;
    @Autowired
    EmployeeService employeeService;


    @Override
    public List<PrinterDto> findAll() {
        List<Printer> responseEntity = printerRepository.findAll();
        List<PrinterDto> responseDto = PrinterMapper.mapToDTO(responseEntity);
       return responseDto;
    }

    @Override
    public PrinterDto add(PrinterDto printerDto) {

        Printer printer = PrinterMapper.mapToEntity(printerDto);
        log.info("Printer: "+ printer);
        Printer savedPrinter = printerRepository.saveAndFlush(printer);
        log.info("saved printer: "+  savedPrinter);
        Printer printerResponseEntity = printerRepository.getById(savedPrinter.getId());
        log.info("printer response entity: " + printerResponseEntity);
        return PrinterMapper.mapToDTO(printerResponseEntity);
    }

    @Override
    public PrinterDto findById(Long id) {
        return PrinterMapper.mapToDTO(printerRepository.findById(id).get());
    }

    @Override
    public Optional<List<Printer>> findByEmployeeId(Long id) {
        return printerRepository.findByEmployeeId(id);
    }

    @Override
    public List<Printer> findAllByEmployee(EmployeeDto employeeDto) {

        return printerRepository.findAllByEmployee(EmployeeMapper.mapToEntity(employeeDto));
    }

    @Override
    public void deleteById(Long id) {
        printerRepository.deleteById(id);
    }
}
