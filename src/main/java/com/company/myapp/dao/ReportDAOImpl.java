package com.company.myapp.dao;

import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportDAOImpl implements ReportDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from Employee employee", Employee.class);
        List<Employee> emps = query.list();
        session.close();
        return emps;
    }

    @Override
    public List<Card> getReports(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select card from Card card " +
                "WHERE card.emp = " + id, Card.class);
        List<Card> cards = query.list();
        session.close();
        return cards;
    }
}
