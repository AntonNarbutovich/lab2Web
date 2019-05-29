package com.company.myapp.service;

import com.company.myapp.dao.ReportDAO;
import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    @Autowired
    UserService userService;

    @Override
    public void getEmployees(Model model) {
        List<Employee> employees = reportDAO.getEmployees();
        model.addAttribute("employees", employees);
        userService.getUserImage(model, SecurityContextHolder.getContext().getAuthentication().getName());

    }

    @Override
    public void getReports(Model model, Long id) {
        List<Card> cards = reportDAO.getReports(id);
        List<Integer> salaries = new ArrayList<>(cards.size());
        for(Integer sal : salaries){
            if (cards.get(salaries.indexOf(sal)).getSalary_type().toString() == "FIXED"){
                sal = cards.get(salaries.indexOf(sal)).getFixed_salary();
            }
            else{
                sal = cards.get(salaries.indexOf(sal)).getWork_time() * cards.get(salaries.indexOf(sal)).getTariff();
            }
        }
        model.addAttribute("reports", cards);
        model.addAttribute("salaries", salaries);
    }

}
