package com.company.myapp.controller;

import com.company.myapp.service.EmployeeService;
import com.company.myapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getReports(Model model){
        reportService.getEmployees(model);
        return "reports";
    }

    @GetMapping("{id}")
    public String getReports(Model model, @PathVariable Long id){
        reportService.getReports(model, id);
        employeeService.getUser(model, id);
        return "empReports";
    }
}
