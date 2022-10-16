package com.minvoo.iteis.controller.rest;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.entity.Role;
import com.minvoo.iteis.mapper.PrinterMapper;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/printers")
public class PrinterController {

    @Autowired
    PrinterService printerService;
    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<?> getAllPrinters() {
        return new ResponseEntity<>(printerService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getPrinter(@PathVariable Long id) {
        return new ResponseEntity<>(printerService.findById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping // /api/printer
    public ResponseEntity<?> savePrinterOrChangeDetails(@RequestBody Printer printer) {
        PrinterDto printerDto = PrinterMapper.mapToDTO(printer);
        return new ResponseEntity<>(printerService.add(printerDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrinter(@PathVariable Long id) {
        printerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
