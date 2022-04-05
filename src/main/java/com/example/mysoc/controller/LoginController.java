package com.example.mysoc.controller;

import com.example.mysoc.entity.User;
import com.example.mysoc.service.LoginService;
import com.example.mysoc.service.UserService;
import com.example.mysoc.service.impl.LoginServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
//@Component
public class LoginController {

//    @Autowired
    public LoginService loginService;

    @PostMapping("/login/{user_id}/{pass}")
    public User validateLogin(@PathVariable("user_id")Long id, @PathVariable("pass")String password)
    {
        return loginService.validateLogin(id,password);
//        return null;
    }
}
