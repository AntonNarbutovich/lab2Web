package com.company.myapp.service;

import com.company.myapp.model.entity.User;
import org.springframework.ui.Model;

public interface UserService {

    User getUser(String login);

    void getUserImage(Model model, String login);

    void getEmp(Model model, String login);
}
