package com.innova.controller;

import com.innova.entity.UserEntity;
import com.innova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @RestController annotation specifies it is a RestController.
@RestController
// When @RequestMapping used on a class, it makes that
// class do all the work related to the specified URL.
@RequestMapping("/api/v1/users")
public class UserRest {
    private UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    // Find all users
    // http://localhost:3030/api/v1/users/getAllUser
    @GetMapping("/getAllUser")
    public List<UserEntity> findAllUser(){
        return userService.findAllUsers();
    }

    // Find users by their Id
    // http://localhost:3030/api/v1/users/{id}
    @GetMapping("{id}")
    public String findUserById(@PathVariable(name="id") Long id ){
        // NullPointerException almamak için
        Optional<UserEntity> optional=userService.findUserById(id);
        if(optional.isPresent()){
            UserEntity userEntity= optional.get();
            return "User Find : "+userEntity;
        }else{
            return " User can't find! ";
        }
    }

    // Delete users by their Id
    // http://localhost:3030/api/v1/users/deleteUser/{id}
    @GetMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable(name="id") Long id){
        userService.deleteUserById(id);
        return "User " + id + " deleted.";
    }

}
