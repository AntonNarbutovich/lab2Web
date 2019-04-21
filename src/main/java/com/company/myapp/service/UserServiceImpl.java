package com.company.myapp.service;

import com.company.myapp.dao.LoginDAO;
import com.company.myapp.model.entity.Employee;
import com.company.myapp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public User getUser(String login) {
        return loginDAO.getUser(login);
    }

    @Override
    public void getUserImage(Model model, String login) {
        byte[] image = getUser(login).getEmp().getImage();
        model.addAttribute("image", image);
    }

    @Override
    public void getEmp(Model model, String login) {
        Employee emp = getUser(SecurityContextHolder.getContext().getAuthentication().getName()).getEmp();
        model.addAttribute("emp", emp);
    }
}
