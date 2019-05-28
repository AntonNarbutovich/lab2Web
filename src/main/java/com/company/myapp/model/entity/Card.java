package com.company.myapp.model.entity;


import com.company.myapp.utils.Salary_type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "card")
public class Card extends BaseEntity {
    @Column(name = "mounth")
    private String mounth;

    @Column(name = "work_time")
    private int work_time;

    @Enumerated(EnumType.STRING)
    @Column(name = "salary_type")
    private Salary_type salary_type;

    @Column(name = "tariff")
    private Integer tariff;

    @Column(name = "fixed_salary")
    private Integer fixed_salary;
//todo
    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee emp;

    public String getMounth() {
        return mounth;
    }

    public void setMounth(String mounth) {
        this.mounth = mounth;
    }

    public int getWork_time() {
        return work_time;
    }

    public void setWork_time(int work_time) {
        this.work_time = work_time;
    }

    public Salary_type getSalary_type() {
        return salary_type;
    }

    public void setSalary_type(Salary_type salary_type) {
        this.salary_type = salary_type;
    }

    public Integer getTariff() {
        return tariff;
    }

    public void setTariff(Integer tariff) {
        this.tariff = tariff;
    }

    public Integer getFixed_salary() {
        return fixed_salary;
    }

    public Employee getEmp_id() {
        return emp;
    }

    public void setEmp_id(Employee emp_id) {
        this.emp = emp_id;
    }

    public void setFixed_salary(Integer fixed_salary) {
        this.fixed_salary = fixed_salary;

    }
}
