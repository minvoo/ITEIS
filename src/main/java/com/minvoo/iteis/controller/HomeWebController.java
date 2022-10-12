package com.minvoo.iteis.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {

    @GetMapping("/")
public String showMainPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();

        if (principal != null) {
            model.addAttribute("principal", authentication.getName());
        } else {
            model.addAttribute("principal", "niezalogowany");
        }
        return "home.html";
}
}
