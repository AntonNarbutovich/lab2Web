package com.company.myapp.controller;

import com.company.myapp.model.entity.Employee;
import com.company.myapp.service.EmployeeService;
import com.company.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private static final String SUCCESS = "success";
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getEmployees(Model model) {
        employeeService.getAll(model);
        employeeService.getUsersToAdd(model);
        employeeService.getUsersToDelete(model);
        userService.getUserImage(model, SecurityContextHolder.getContext().getAuthentication().getName());
        return "employee";
    }

    @PostMapping(value = "/add")
    public String addEmployee(Model model, @RequestParam("id") Long id) {
        employeeService.addEmployee(model, id);
        return SUCCESS;
    }

    @PostMapping(value = "/delete")
    public String deleteEmployee(Model model, @RequestParam("id") Long id) {
        employeeService.deleteEmployee(model, id);
        return SUCCESS;
    }
//    @GetMapping(value = "/add")
//    public String getUsersToAdd(Model model){
//        employeeService.getUsersToAdd(model);
//        return "employee";
//    }

//    @GetMapping(value = "/{id}")
//    public String openNews(@PathVariable("id") Long id, Model model){
//        employeeService.getById(id, model);
//        return "newsPage";
//    }
}
