package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.ComputerDto;
import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.service.ComputerService;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.minvoo.iteis.common.PageMappingInfo.ELEMENTS_DELETE_PATH;

@Controller
@RequestMapping
public class ComputerWebController {

    @Autowired
    private ComputerService computerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("computers/list")
    public String getAllComputers(Model model) {

        model.addAttribute("computers", computerService.findAll());
        return "/computers/computers-list";
    }

    @GetMapping("/computers/add")
    public String addComputerPage(Model model) {

        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        model.addAttribute("computer", new ComputerDto());

        return "computers/computer-add-or-update.html";
    }

    @PostMapping("/computers/add")
    public String addNewComputer(ComputerDto computerDto, @RequestParam("employeeId") Long empId) {
        EmployeeDto request = Optional.of(employeeService.findById(empId)).orElse(new EmployeeDto());
        computerDto.setEmployee(EmployeeMapper.mapToEntity(request));
        computerService.add(computerDto);
        return "redirect:/computers/list";
    }


    @GetMapping("/computers/change/{id}")
    public String changeMobileDetails(@PathVariable("id") Long id, Model model) {

        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        ComputerDto computerDtoRequest = computerService.findById(id);
        model.addAttribute("computer", computerDtoRequest);

        return "computers/computer-add-or-update.html";
    }

    @PostMapping("/computers/" + ELEMENTS_DELETE_PATH)
    public String deletePrinter(@PathVariable("id") Long id) {
        computerService.deleteById(id);
        return "redirect:/computers/list";
    }

}
