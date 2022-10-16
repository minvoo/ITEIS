package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.utils.CurrentUserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.minvoo.iteis.common.PageMappingInfo.*;

@Controller
@RequestMapping(EMPLOYEES_WEB_PATH)
@Slf4j
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CurrentUserUtils currentUserUtils;

    @GetMapping(ELEMENTS_LIST_WEB_PATH) // /employee/list
    public String getAllEmployees(Model model) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/employees-list.html";
    }
    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employees/employee-check-details.html";
    }
    @PostMapping(ELEMENTS_DELETE_PATH)
    public String deleteEmployee(@PathVariable("id") Long id,
                                 Authentication authentication) {
        employeeService.deleteById(id, authentication);
        return "redirect:/employees/list";
    }
    @GetMapping(EMPLOYEE_PROFILE_PATH)
    public String getProfilePage(Authentication authentication,
                                    Model model) {

        Employee employee = currentUserUtils.getCurrentUser(authentication);
        model.addAttribute("employee", employee);
        return "/employees/employee-profile.html";
    }
    @GetMapping(EMPLOYEE_PROFILE_PASSWORD_CHANGE_PATH)
    public String getPasswordChangePage(Authentication authentication,
                                        Model model) {

        Employee currentUser = currentUserUtils.getCurrentUser(authentication);
        EmployeeDto employeeDto = EmployeeMapper.mapToDto(currentUser);
        model.addAttribute("employee", employeeDto);
        return "employees/employee-change-password.html";
    }

    @PostMapping(EMPLOYEE_PROFILE_PASSWORD_CHANGE_PATH)
        public String changePassword(Authentication authentication,
                                     @ModelAttribute EmployeeDto employeeDto) {
        Employee emp = currentUserUtils.getCurrentUser(authentication);
        employeeService.changePassword(employeeDto, employeeDto.getId());
        return "redirect:/employees"+EMPLOYEE_PROFILE_PATH;
    }
    @GetMapping(ELEMENTS_DETAILS_PATH)
        public String getChangeDetailsPage(@PathVariable("id") Long id,
                                           Model model) {
        EmployeeDto employeeDto = employeeService.findById(id);
        model.addAttribute("employee", employeeDto);
        return "employees/employee-change-details.html";
    }
    @PostMapping(DETAILS_PATH)
        public String updateDetails(@ModelAttribute EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto, employeeDto.getId());
        return "redirect:/employees"+ELEMENTS_LIST_WEB_PATH;
    }

}
