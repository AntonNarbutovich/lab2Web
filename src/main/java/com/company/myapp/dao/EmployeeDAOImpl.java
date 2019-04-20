package com.company.myapp.dao;

import com.company.myapp.model.entity.Employee;
import com.company.myapp.model.entity.GlobalEmployee;
import com.company.myapp.utils.EmployeeUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from Employee employee", Employee.class);
        List<Employee> emps = query.list();
        session.close();
        return emps;
    }

    @Override
    public List<GlobalEmployee> getUsersToAdd() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from GlobalEmployee employee " +
                "where employee.id NOT IN (select emp.id from Employee emp)");
        List<GlobalEmployee> emps = query.list();
        session.close();
        return emps;
    }

    @Override
    public List<GlobalEmployee> getUsersToDelete() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from Employee employee " +
                "where employee.id NOT IN (select emp.id from GlobalEmployee emp)");
        List<GlobalEmployee> emps = query.list();
        session.close();
        return emps;
    }

    @Override
    public Employee getById(Long id) {
        Session session = sessionFactory.openSession();
        Employee emp = session.get(Employee.class, id);
        session.close();
        return emp;
    }

    @Override
    public GlobalEmployee getGlobalById(Long id) {
        Session session = sessionFactory.openSession();
        GlobalEmployee emp = session.get(GlobalEmployee.class, id);
        session.close();
        return emp;
    }

    @Override
    public void add(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(EmployeeUtil.convert(getGlobalById(id)));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(getById(id));
        session.getTransaction().commit();
        session.close();
    }
}
