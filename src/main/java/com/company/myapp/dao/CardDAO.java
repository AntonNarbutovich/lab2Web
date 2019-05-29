package com.company.myapp.dao;

import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import com.company.myapp.utils.Salary_type;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface CardDAO {
    List<Card> getAll();

    Card getById(Long id);

    Card getByEmployeeId(Long id);

    List<Employee> getEmployeesWithoutCard ();

    void update(Long id, Salary_type salary_type, Integer tariff, Integer fixed_salary);

    void add(Employee emp, String mounth, Integer work_time, Salary_type salary_type,
             Integer tariff, Integer fixed_salary);

    void delete(Long id);
}
