package com.company.myapp.controller;

import com.company.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String start(Model model){
        userService.getUserImage(model, SecurityContextHolder.getContext().getAuthentication().getName());
        return "hello";
}

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/info")
    public String info(Model model){
        userService.getEmp(model, SecurityContextHolder.getContext().getAuthentication().getName());
        return "empInfo";
    }

    @GetMapping("/accessDenied")
    public String error() {return "accessDenied";}
}
