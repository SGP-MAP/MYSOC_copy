package com.example.mysoc.service;

import com.example.mysoc.entity.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getUsers();
    public User updateUser(Long id,User user);
    public void deleteUser(Long id);
    public  User validateLogin(Long id, String password);
}
