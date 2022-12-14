package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.service.AuthenticationService;
import com.minvoo.iteis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("authentication")//pre-path
public class AuthenticationWebController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/sign-up") //authentication/sign-up
    public String getSignUpPage(Model model) {
        if (authenticationService.isUserLogged() && !authenticationService.isLoggedUserIsAdmin()) {
            return "redirect:/";
        }
        model.addAttribute("signup", new EmployeeDto());
        model.addAttribute("user", new EmployeeDto());
        return "authentication/sign-up.html";
    }

    @PostMapping("/sign-up")
    public String processRegister(Employee employee, Model model) {
        if (authenticationService.isUserLogged() && !authenticationService.isLoggedUserIsAdmin()) {
            return "redirect:/";
        }
        try {
            employeeService.saveEmployee(employee);
            model.addAttribute("errorMsg", null);
        } catch (Exception ex) {
            model.addAttribute("errorMsg", "Employee with that username or email " +
                    "already exist");
            model.addAttribute("signup", new EmployeeDto());
            model.addAttribute("user", new EmployeeDto());
            return "authentication/sign-up.html";
        }
        model.addAttribute("user", new EmployeeDto());
        if (authenticationService.isLoggedUserIsAdmin()) {
            return "redirect:/employees/list";
        }
        return "redirect:/";
    }

}