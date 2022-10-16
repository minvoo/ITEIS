package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.dto.MobileDto;
import com.minvoo.iteis.mapper.EmployeeMapper;
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
public class MobileWebController {

    @Autowired
    private MobileService mobileService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("mobiles/list")
    public String getAllMobiles(Model model) {

        model.addAttribute("mobiles", mobileService.findAll());
        return "/mobiles/mobiles-list";
    }

    @GetMapping("/mobiles/add")
    public String addMobilePage(Model model) {

        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        model.addAttribute("mobile", new MobileDto());

        return "mobiles/mobile-add-or-update.html";
    }

    @PostMapping("/mobiles/add")
    public String addNewMobile(MobileDto mobileDto, @RequestParam("employeeId") Long empId) {
        EmployeeDto request = Optional.of(employeeService.findById(empId)).orElse(new EmployeeDto());
        mobileDto.setEmployee(EmployeeMapper.mapToEntity(request));
        mobileService.add(mobileDto);
        return "redirect:/mobiles/list";
    }


    @GetMapping("/mobiles/change/{id}")
    public String changeMobileDetails(@PathVariable("id") Long id, Model model) {

        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees", allEmployees);
        MobileDto mobileRequest = mobileService.findById(id);
        model.addAttribute("mobile", mobileRequest);

        return "mobiles/mobile-add-or-update.html";
    }

    @PostMapping("/mobiles/" + ELEMENTS_DELETE_PATH)
    public String deletePrinter(@PathVariable("id") Long id) {
        mobileService.deleteById(id);
        return "redirect:/mobiles/list";
    }

}
