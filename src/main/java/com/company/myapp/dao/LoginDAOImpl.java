package com.company.myapp.dao;

import com.company.myapp.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String login) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select user from User user where user.login = :login")
                .setParameter("login", login);
        User user = (User) query.getSingleResult();
        session.close();
        return user;
    }
}
