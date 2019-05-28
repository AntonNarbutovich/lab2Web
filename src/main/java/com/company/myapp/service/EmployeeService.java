package com.company.myapp.service;

import org.springframework.ui.Model;

public interface EmployeeService {

    void getAll(Model model);

    void getUsersToAdd(Model model);

    void getUsersToDelete(Model model);

    void addEmployee(Model model, Long id);

    void deleteEmployee(Model model, Long id);

    void getUser(Model model, Long id);
}
