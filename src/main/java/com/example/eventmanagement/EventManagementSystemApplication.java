package com.example.eventmanagement;

import com.example.eventmanagement.controllers.UserController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EventManagementSystemApplication {
    public static void main(String[] args) {
        UserController userController = new UserController();

        // Test user registration
        //1: pass
        userController.registerUser("abc", "ab.cd1@gmail.com", "Password@1234");
        //2: pass
        userController.registerUser("efg", "ef.gh1@gmail.com", "Password@567");
        //3: fail saying email exists
        userController.registerUser("abc", "ab.cd1@gmail.com", "Password@1234");
        //4: fail email invalid
        userController.registerUser("abcx", "1Ab.cd1@g1.com1", "1234");

        //Test user login
        //1: pass
        userController.loginUser("ab.cd1@gmail.com", "Password@1234");
        //2: email doesnot exist
        userController.loginUser("ab.cd@gmail.com", "Password@1234");
        //3: invalid password
        userController.loginUser("ab.cd1@gmail.com", "Password@12345");

        //Test updating user profile
        //1: email already exists, update failed
        userController.UpdateUserProfile("1", "abcd", "ab.cd1@gmail.com");
        //2: email updated
        userController.UpdateUserProfile("2", "efg", "efgh@gmail.com");
        //3: new user added-doubtful
        userController.UpdateUserProfile("1", "abcd", "ab.cd@gmail.com");


        }
    }
}