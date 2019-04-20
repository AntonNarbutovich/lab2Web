package com.company.myapp.dao;

import com.company.myapp.model.entity.Employee;
import com.company.myapp.model.entity.GlobalEmployee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO {
    List<Employee> getAll();

    List<GlobalEmployee> getUsersToAdd();

    List<GlobalEmployee> getUsersToDelete();

    Employee getById(Long id);

    GlobalEmployee getGlobalById(Long id);

    void add(Long id);

    void delete(Long id);
}
