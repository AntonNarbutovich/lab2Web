package com.company.myapp.service;

import com.company.myapp.utils.Salary_type;
import org.springframework.ui.Model;

public interface CardService {
    void getAll(Model model);

    void getByEmployee(Model model, Long id);

    void update(Model model, Long id, Salary_type salary_type, Integer tariff, Integer fixed_salary);

    void getEmployeesWithoutCard (Model model);

    void addCard(Model model ,Long id, String mounth, Integer work_time, Salary_type salary_type,
                 Integer tariff, Integer fixed_salary);

}
