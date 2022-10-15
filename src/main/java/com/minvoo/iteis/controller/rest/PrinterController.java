package com.minvoo.iteis.controller.rest;

import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class PrinterController {

    @Autowired
    PrinterService printerService;
    @Autowired
    EmployeeService employeeService;


}
