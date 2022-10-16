package com.minvoo.iteis.controller.rest;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.mapper.ComputerMapper;
import com.minvoo.iteis.mapper.PrinterMapper;
import com.minvoo.iteis.service.ComputerService;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    @Autowired
    ComputerService computerService;
    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<?> getAllComputers() {
        return new ResponseEntity<>(computerService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getPrinter(@PathVariable Long id) {
        return new ResponseEntity<>(computerService.findById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping // /api/computer
    public ResponseEntity<?> saveComputerOrChangeDetails(@RequestBody Computer computer) {
        ComputerDto computerDto = ComputerMapper.mapToDto(computer);
        return new ResponseEntity<>(computerService.add(computerDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComputer(@PathVariable Long id) {
        computerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
