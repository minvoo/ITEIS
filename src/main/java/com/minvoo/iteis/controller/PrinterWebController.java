package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.PrinterDto;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.minvoo.iteis.common.PageMappingInfo.ELEMENTS_DELETE_PATH;

@Controller
@RequestMapping
public class PrinterWebController {

    @Autowired
    private PrinterService printerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("printers/list")
    public String getAllPrinters(Model model) {

        model.addAttribute("printers", printerService.findAll());
        return "/printers/printers-list";
    }

    @GetMapping("/printers/add")
    public String addPrinterPage(Model model) {

        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        model.addAttribute("printer", new PrinterDto());

        return "printers/printer-add-or-update.html";
    }

    @PostMapping("/printers/add")
    public String addNewPrinter(PrinterDto printerDto,
                                @RequestParam("employeeId") Long empId) {
        EmployeeDto request = Optional.of(employeeService.findById(empId)).orElse(new EmployeeDto());
        printerDto.setEmployee(EmployeeMapper.mapToEntity(request));
        printerService.add(printerDto);
        return "redirect:/printers/list";
    }


    @GetMapping("/printers/change/{id}")
    public String changePrinterDetails(@PathVariable("id") Long id,
                                 Model model) {

        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        PrinterDto printerRequest = printerService.findById(id);
        model.addAttribute("printer", printerRequest);

        return "printers/printer-add-or-update.html";
    }

    @PostMapping("/printers/" + ELEMENTS_DELETE_PATH)
    public String deletePrinter(@PathVariable("id") Long id) {
        printerService.deleteById(id);
        return "redirect:/printers/list";
    }



}
