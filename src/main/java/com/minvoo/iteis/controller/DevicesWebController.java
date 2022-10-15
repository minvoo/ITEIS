package com.minvoo.iteis.controller;

import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.PrinterService;
import com.minvoo.iteis.utils.CurrentUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.minvoo.iteis.common.PageMappingInfo.EMPLOYEE_PROFILE_PATH;

@Controller
@RequestMapping
public class DevicesWebController {

    @Autowired
    private PrinterService printerService;
    @Autowired
    private CurrentUserUtils currentUserUtils;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees" + EMPLOYEE_PROFILE_PATH +"/devices")
    public String getPrintersByCurrentLoggedUser(Authentication authentication,
                                                 Model model) {
        Employee currentUser = currentUserUtils.getCurrentUser(authentication);

        List<Printer> printers = printerService.findAllByEmployee(EmployeeMapper.mapToDto(currentUser));
        model.addAttribute("printers", printers);
        model.addAttribute("employee", currentUser);
        return "/devices/devices-by-employee.html";
    }
}
