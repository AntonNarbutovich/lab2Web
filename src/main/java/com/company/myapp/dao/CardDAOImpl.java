package com.company.myapp.dao;

import com.company.myapp.model.entity.Card;
import com.company.myapp.model.entity.Employee;
import com.company.myapp.utils.Salary_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Card> getAll() {
        Session session = sessionFactory.openSession();
        List<Card> cards = session.createQuery("SELECT card FROM Card card", Card.class).getResultList();
        session.close();
        return cards;
    }

    @Override
    public void update(Long id, Salary_type salary_type, Integer tariff, Integer fixed_salary) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "UPDATE Card set tariff = :tariff, salary_type = :salary_type, fixed_salary = :fixed_salary "  +
                "WHERE id = :card_id";
        Query query = session.createQuery(hql);
        query.setParameter("tariff", tariff);
        query.setParameter("salary_type", salary_type);
        query.setParameter("fixed_salary", fixed_salary);
        query.setParameter("card_id", id);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Rows affected: " + result);
        session.close();
    }


    @Override
    public Card getById(Long id) {
        Session session = sessionFactory.openSession();
        Card card = session.get(Card.class, id);
        session.close();
        return card;
    }

    @Override
    public Card getByEmployeeId(Long emp_id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select card from Card card where card.emp.id = :employee_id");
        query.setParameter("employee_id", emp_id);
        Card card = (Card) query.getSingleResult();
        session.close();
        return card;
    }

    @Override
    public List<Employee> getEmployeesWithoutCard() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select employee from Employee employee where employee.id " +
                "not in (select card.emp.id from Card card)");
        List<Employee> emps = query.list();
        return emps;
    }

    @Override
    public void add(Employee emp, String mounth, Integer work_time, Salary_type salary_type,
                    Integer tariff, Integer fixed_salary) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Card card = new Card();
        card.setMounth(mounth);
        card.setWork_time(work_time);
        card.setSalary_type(salary_type);
        card.setTariff(tariff);
        card.setFixed_salary(fixed_salary);
        card.setEmp_id(emp);
        session.save(card);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

    }
}

