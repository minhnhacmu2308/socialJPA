package com.dtu.social_it.services;

import com.dtu.social_it.domains.User;

import java.util.List;

public interface UserService {

    User save(User user);

    boolean login(String email, String password);

    boolean checkEmail(String email);

    List<User> findAll();

    User findByEmail(String email);

    User findById(int id);

    void activeAccount(String email,int number);

}
