package com.company.myapp.service;

import com.company.myapp.dao.EmployeeDAO;
import com.company.myapp.model.entity.Employee;
import com.company.myapp.model.entity.GlobalEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void getAll(Model model) {
        List<Employee> employees = employeeDAO.getAll();
        model.addAttribute("employees", employees);
    }

    @Override
    public void getUsersToAdd(Model model) {
        List<GlobalEmployee> employees = employeeDAO.getUsersToAdd();
        model.addAttribute("users_to_add", employees);
    }

    @Override
    public void getUsersToDelete(Model model) {
        List<GlobalEmployee> employees = employeeDAO.getUsersToDelete();
        model.addAttribute("users_to_delete", employees);
    }

    @Override
    public void addEmployee(Model model, Long id) {
        employeeDAO.add(id);
        model.addAttribute("name", employeeDAO.getById(id).getName());
        model.addAttribute("surname", employeeDAO.getById(id).getSurname());
        model.addAttribute("action", "added");
    }

    @Override
    public void deleteEmployee(Model model, Long id) {
        model.addAttribute("name", employeeDAO.getById(id).getName());
        model.addAttribute("surname", employeeDAO.getById(id).getSurname());
        model.addAttribute("action", "deleted");
        employeeDAO.delete(id);
    }

    @Override
    public void getUser(Model model, Long id) {
        employeeDAO.getById(id);
        model.addAttribute("name", employeeDAO.getById(id).getName());
        model.addAttribute("surname", employeeDAO.getById(id).getSurname());
    }

}
