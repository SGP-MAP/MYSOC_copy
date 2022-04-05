package com.example.mysoc.controller;

import com.example.mysoc.entity.User;
import com.example.mysoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/list")
        public List<User> getUsers(){
            return userService.getUsers();
        }
    @PutMapping("/update/{user_id}")
    public User updateUser(@RequestBody User user,@PathVariable("user_id")Long id){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/delet/{user_id}")
    public String deleteUser(@PathVariable("user_id")Long id){
        userService.deleteUser(id);
        return "yeahh boy";
    }
    @PostMapping("/login/{user_id}/{pass}")
    public User validateLogin(@PathVariable("user_id")Long id,@PathVariable("pass")String password)
    {
        return userService.validateLogin(id,password);
    }

}
