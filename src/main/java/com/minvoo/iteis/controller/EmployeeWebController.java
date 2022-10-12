package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
@Slf4j
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list") // /employee/list
    public String getAllEmployees(Model model) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/employees_list.html";
    }

    //admins
    @GetMapping("/{id}")
    public String getEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employees/employee-details.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

    //users
    @GetMapping("/profile")
    public String getEmployeeByUuid(Authentication authentication,
                                    Model model) {

        Optional<Employee> employeeOptional = employeeService.findByUsername(authentication.getName());
        Employee employee = employeeOptional.get();
        log.info("Current user: " + employee.toString());
        model.addAttribute("employee", employee);
        return "/employees/profile.html";
    }


}
