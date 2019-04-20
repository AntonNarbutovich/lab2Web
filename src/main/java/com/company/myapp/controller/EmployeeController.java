package com.company.myapp.controller;

import com.company.myapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getEmployees(Model model){
        employeeService.getAll(model);
        employeeService.getUsersToAdd(model);
        employeeService.getUsersToDelete(model);
        return "employee";
    }

    @PostMapping(value = "/add")
    public String addEmployee(Model model, @RequestParam("id") Long id){
        employeeService.addEmployee(model, id);
        return "success";
    }

    @PostMapping(value = "/delete")
    public String deleteEmployee(Model model, @RequestParam("id") Long id){
        employeeService.deleteEmployee(model, id);
        return "success";
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
