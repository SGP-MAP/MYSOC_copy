package com.example.mysoc.service.impl;

import com.example.mysoc.entity.User;
import com.example.mysoc.repository.AdminRepo;
import com.example.mysoc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginServiceimpl implements LoginService {
    @Autowired
    public AdminRepo userRepository;

    @Override
    public User validateLogin(Long id, String password) {
        System.out.println("final step");
        boolean found=false;
        List<User> all= userRepository.findAll();
        for(User u:all) {
            if (id.equals(u.getId())) {
                if (password.equals(u.getPassword())) {
                    found=true;
                    System.out.println("found");
                    if (u.isAdminFlag() == true) {
                        System.out.println("Admin hai bhai");
                    } else {
                        System.out.println("Admin nahin hai bhai");
                    }

                    return u;
                } else {
                    System.out.println("Wrong Password Try again");
                    return null;
                }
            }
        }
        if(!found)
        {
            System.out.println("Not found any user with given id");
        }

        return null;
    }
}
