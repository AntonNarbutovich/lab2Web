package com.company.myapp.service;

import com.company.myapp.dao.ReportDAO;
import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    @Override
    public void getEmployees(Model model) {
        List<Employee> employees = reportDAO.getEmployees();
        model.addAttribute("employees", employees);
    }

    @Override
    public void getReports(Model model, Long id) {
        List<Card> employees = reportDAO.getReports(id);
        model.addAttribute("reports", employees);
    }
}
