package com.minvoo.iteis.controller;

import com.minvoo.iteis.dto.EmployeeDto;
import com.minvoo.iteis.entity.Employee;
import com.minvoo.iteis.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.minvoo.iteis.common.PageMappingInfo.LOGIN_PAGE;

@Controller
@RequestMapping("/")
public class LoginWebController {
    // TODO: will work on that when I find the way how to make JWT  works on Web Controllers.
    @Autowired
    AuthenticationService authenticationService;
    @GetMapping(LOGIN_PAGE)
    public String getLogin(Model model) {
        if (authenticationService.isUserLogged()) {
            return "redirect:/";
        }
        model.addAttribute("user", new EmployeeDto());
        return "authentication/sign-in.html";
    }
}


// TODO: attempt for JWT tokens
/*
    @PostMapping("/process-login")
        public String processLogin(Model model, Employee employee) {

        if (authenticationService.isUserLogged()) {
            return "redirect:/";
        }

        try {
            authenticationService.signInAndReturnJWT(employee);
        } catch (Exception ex) {
            model.addAttribute("signup", new EmployeeDto());
            model.addAttribute("user", new EmployeeDto());
            return "/authentication/sign-in.html";
        }
        model.addAttribute("user", new EmployeeDto());
        return "redirect:/";



    }
*/

