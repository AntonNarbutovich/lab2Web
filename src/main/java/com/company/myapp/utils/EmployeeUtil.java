package com.company.myapp.utils;

import com.company.myapp.model.entity.Employee;
import com.company.myapp.model.entity.GlobalEmployee;

public abstract class EmployeeUtil {
    public static Employee convert(GlobalEmployee emp){
        Employee employee = new Employee();
        employee.setId(emp.getId());
        employee.setName(emp.getName());
        employee.setSurname(emp.getSurname());
        employee.setRole(emp.getRole());
        employee.setImage(emp.getImage());
        return employee;
    }
}
