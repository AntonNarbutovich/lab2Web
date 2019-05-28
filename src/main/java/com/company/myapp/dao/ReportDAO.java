package com.company.myapp.dao;

import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDAO {

    List<Employee> getEmployees();

    List<Card> getReports(Long id);
}
