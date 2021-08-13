package com.dtu.social_it.servicesImpl;

import com.dtu.social_it.domains.User;
import com.dtu.social_it.respositorys.UserRespository;
import com.dtu.social_it.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRespository userRespository;

    @Override
    public User save(User user) {
        return userRespository.save(user);
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public boolean checkEmail(String email) {
        User user = userRespository.findUserByEmail(email);
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void activeAccount(String email,int number) {
        userRespository.activeAccount(email,number);
    }


}
