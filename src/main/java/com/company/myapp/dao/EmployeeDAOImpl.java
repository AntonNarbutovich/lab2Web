package com.company.myapp.dao;

import com.company.myapp.model.entity.Employee;
import com.company.myapp.model.entity.GlobalEmployee;
import com.company.myapp.utils.EmployeeUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
        return query.list();    }

    @Override
    public List<GlobalEmployee> getUsersToAdd() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from GlobalEmployee employee " +
                "where employee.id NOT IN (select emp.id from Employee emp)");
        return query.list();
    }

    @Override
    public List<GlobalEmployee> getUsersToDelete() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from Employee employee " +
                "where employee.id NOT IN (select emp.id from GlobalEmployee emp)");
        return query.list();
    }

    @Override
    public Employee getById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Employee.class, id);
    }

    @Override
    public GlobalEmployee getGlobalById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(GlobalEmployee.class, id);
    }

    @Override
    @Transactional
    public void add(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(EmployeeUtil.convert(getGlobalById(id)));
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(getById(id));
        session.getTransaction().commit();
    }
}
