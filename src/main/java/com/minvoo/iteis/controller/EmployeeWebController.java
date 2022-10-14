package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String deleteEmployee(@PathVariable("id") Long id,
                                 Authentication authentication) {
        employeeService.deleteById(id, authentication);
        return "redirect:/employees/list";
    }

    //users
    @GetMapping("/profile")
    public String getProfilePage(Authentication authentication,
                                    Model model) {

        Employee employee = getCurrentUser(authentication);
        model.addAttribute("employee", employee);
        return "/employees/profile.html";
    }
    @GetMapping("profile/changepassword")
    public String getPasswordChangePage(Authentication authentication,
                                        Model model) {

        Employee currentUser = getCurrentUser(authentication);
        EmployeeDto employeeDto = EmployeeMapper.mapToDto(currentUser);
        model.addAttribute("employee", employeeDto);
        return "employees/changepassword.html";
    }

    @PostMapping("profile/changepassword")
        public String changePassword(Authentication authentication,
                                     @ModelAttribute EmployeeDto employeeDto) {
        Employee emp = getCurrentUser(authentication);
        employeeService.changePassword(employeeDto, employeeDto.getId());
        return "redirect:/employees/profile";
    }

    @GetMapping("/details/{id}")
        public String getChangeDetailsPage(@PathVariable("id") Long id,
                                           Model model) {
        EmployeeDto employeeDto = employeeService.findById(id);
        model.addAttribute("employee", employeeDto);

        return "employees/changedetails.html";
    }

    @PostMapping("/details")
        public String updateDetails(@ModelAttribute EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto, employeeDto.getId());
        return "redirect:/employees/list";
    }

    private Employee getCurrentUser(Authentication authentication) {
        Optional<Employee> employeeOptional = employeeService.findByUsername(authentication.getName());
        Employee employee = employeeOptional.get();
        return employee;
    }
}
