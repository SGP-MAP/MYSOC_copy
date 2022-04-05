package com.example.mysoc.service;

import com.example.mysoc.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public User validateLogin(Long id, String password);
}
