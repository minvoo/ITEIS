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
    private PrinterRepository printerRepository;
    @Autowired
    private EmployeeService employeeService;

    /**
     * Finds all printers saved in database
     * @return List<PrinterDto>
     */
    @Override
    public List<PrinterDto> findAll() {
        List<Printer> responseEntity = printerRepository.findAll();
        List<PrinterDto> responseDto = PrinterMapper.mapToDTO(responseEntity);
       return responseDto;
    }

    /**
     * Adds printer to database
     * @param printerDto - object to add to database
     * @return PrinterDto object saved to database
     */
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

    /**
     * Finds entity in database by id
     * @param id - primary key value of entity
     * @return PrinterDto object
     */
    @Override
    public PrinterDto findById(Long id) {
        return PrinterMapper.mapToDTO(printerRepository.findById(id).get());
    }

    /**
     * Finds entity in database by Employee ID.<br>
     * Returns Optional in case of getting null from database.
     * @param id - primary key value of Employee Entity
     * @return Optional<List<Printer>
     */
    @Override
    public Optional<List<Printer>> findByEmployeeId(Long id) {
        return printerRepository.findByEmployeeId(id);
    }

    /**
     * Finds entity in database by Employee entity<br>
     * @param employeeDto - EmployeeDto converted from Entity using Mapper object
     * @return List<Printer>
     */
    @Override
    public List<Printer> findAllByEmployee(EmployeeDto employeeDto) {

        return printerRepository.findAllByEmployee(EmployeeMapper.mapToEntity(employeeDto));
    }

    /**
     * Deletes entity by id
     * @param id - id on entity to delete
     * @returns void
     */
    @Override
    public void deleteById(Long id) {
        printerRepository.deleteById(id);
    }
}
