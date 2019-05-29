package com.company.myapp.service;

import com.company.myapp.dao.CardDAO;
import com.company.myapp.dao.EmployeeDAO;
import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import com.company.myapp.utils.Salary_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {
    @Autowired
    CardDAO cardDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public void getAll(Model model) {
        List<Card> cards = cardDAO.getAll();
        model.addAttribute("cards", cards);
    }

    @Override
    public void getByEmployee(Model model, Long id) {
        Card card = cardDAO.getByEmployeeId(id);
        model.addAttribute("emp_card", card);
    }

    @Override
    public void update(Model model, Long id, Salary_type salary_type, Integer tariff, Integer fixed_salary) {
        model.addAttribute("name", "card");
        model.addAttribute("surname", "");
        model.addAttribute("action", "updated");
        cardDAO.update(id, salary_type, tariff, fixed_salary);
    }

    @Override
    public void getEmployeesWithoutCard(Model model) {
        List<Employee> emps = cardDAO.getEmployeesWithoutCard();
        model.addAttribute("no_card_employees", emps);
    }

    @Override
    public void addCard(Model model, Long id, String mounth, Integer work_time, Salary_type salary_type,
                        Integer tariff, Integer fixed_salary) {
        model.addAttribute("name", "card");
        model.addAttribute("surname", "");
        model.addAttribute("action", "created");
        Employee emp = employeeDAO.getById(id);
        cardDAO.add(emp, mounth, work_time, salary_type, tariff, fixed_salary);
    }
}
