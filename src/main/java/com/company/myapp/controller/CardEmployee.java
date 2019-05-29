package com.company.myapp.controller;

import com.company.myapp.service.CardService;
import com.company.myapp.service.EmployeeService;
import com.company.myapp.utils.Salary_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/card")
public class CardEmployee {

    @Autowired
    CardService cardService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String getEmployees(Model model){
        employeeService.getAll(model);
        cardService.getEmployeesWithoutCard(model);
        //userService.getUserImage(model, SecurityContextHolder.getContext().getAuthentication().getName());
        return "card";
    }
    @GetMapping("/update")
    public String updateEmployee(Model model, @RequestParam("id") Long id){
        cardService.getByEmployee(model, id);
        return "update";
    }
    @PostMapping("/update_finish")
    public String updateEmployee(Model model, @RequestParam("card_id") Long id, @RequestParam("salary_type")
                                Salary_type salary_type, @RequestParam("tariff") Integer tariff,
                                 @RequestParam("fixed_salary") Integer fixed_salary) {

        cardService.update(model, id, salary_type, tariff, fixed_salary);
        return "success";
    }

    @GetMapping("/add")
    public String getEmployeesWithoutCard(Model model, @RequestParam("emp_id") Long id, @RequestParam("mounth")
            String mounth, @RequestParam("work_time") Integer work_time, @RequestParam("salary_type")
            Salary_type salary_type, @RequestParam("tariff") Integer tariff, @RequestParam("fixed_salary") Integer fixed_salary) {
        cardService.addCard(model, id, mounth, work_time, salary_type, tariff, fixed_salary);
        return "success";
    }
}
