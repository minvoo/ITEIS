package com.minvoo.iteis.controller;

import com.minvoo.iteis.entity.Computer;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.entity.Mobile;
import com.minvoo.iteis.entity.Printer;
import com.minvoo.iteis.mapper.EmployeeMapper;
import com.minvoo.iteis.service.ComputerService;
import com.minvoo.iteis.service.EmployeeService;
import com.minvoo.iteis.service.MobileService;
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
    private MobileService mobileService;

    @Autowired
    private ComputerService computerService;


    @GetMapping("employees" + EMPLOYEE_PROFILE_PATH +"/devices")
    public String getPrintersByCurrentLoggedUser(Authentication authentication,
                                                 Model model) {
        Employee currentUser = currentUserUtils.getCurrentUser(authentication);

        List<Printer> printers = printerService.findAllByEmployee(EmployeeMapper.mapToDto(currentUser));
        List<Mobile> mobiles = mobileService.findAllByEmployee(EmployeeMapper.mapToDto(currentUser));
        List<Computer> computers = computerService.findAllByEmployee(EmployeeMapper.mapToDto(currentUser));

        model.addAttribute("printers", printers);
        model.addAttribute("mobiles", mobiles);
        model.addAttribute("computers", computers);
        model.addAttribute("employee", currentUser);
        return "/devices/devices-by-employee.html";
    }
}
