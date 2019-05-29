package com.company.myapp.service;

import org.springframework.ui.Model;

public interface ReportService {

    void getEmployees(Model model);

    void getReports(Model model, Long id);
}
