package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllComputers() {
        return new ResponseEntity<>(computerService.getAllComputers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getComputer(@PathVariable Long id) {
        return new ResponseEntity<>(computerService.findById(id), HttpStatus.OK);
    }

    @PostMapping // /api/employee
    public ResponseEntity<?> saveComputer(@RequestBody Computer computer, Long employeeId) {
        return new ResponseEntity<>(computerService.saveComputer(computer, employeeId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComputer(@PathVariable Long id,
                                            @RequestBody ComputerDto computerDto) {
        ComputerDto computerResponse = computerService.updateComputer(computerDto, id);
        return new ResponseEntity<>(computerResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComputer(@PathVariable Long id) {
        computerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
