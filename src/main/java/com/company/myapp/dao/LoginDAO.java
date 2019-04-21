package com.company.myapp.dao;

import com.company.myapp.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {
    User getUser(String login);
}
