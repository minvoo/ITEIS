package com.minvoo.iteis.controller;

import com.minvoo.iteis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.minvoo.iteis.common.PageMappingInfo.ADMIN_WEB_PATH;
import static com.minvoo.iteis.common.PageMappingInfo.ADMIN_WEB_ROLE_ID_PATH;

@RequestMapping(ADMIN_WEB_PATH)
@Controller
public class AdminWebController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(ADMIN_WEB_ROLE_ID_PATH)
    public String changeUserRole(@PathVariable("id") Long id) {
        employeeService.changeRole(id);
        return "redirect:/employees/list";
    }
}
