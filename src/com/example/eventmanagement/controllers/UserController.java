package com.example.eventmanagement.controllers;

import com.example.eventmanagement.service.UserService;

public class UserController {
    //create user service object
    private UserService userService = new UserService();

        public void registerUser(String name, String email, String password){
            String result = userService.registerUser(name, email ,password);
            System.out.println(result);
        }
        public void loginUser(String email, String password){
            String result = userService.loginUser(email, password);
            System.out.println(result);
        }
        public void UpdateUserProfile(String userId, String newName, String newEmail){
            String result = userService.UpdateUserProfile(userId, newName, newEmail);
            System.out.println(result);
        }
}
