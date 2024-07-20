package com.example.eventmanagement.service;
import com.example.eventmanagement.model.User;
import com.example.eventmanagement.util.PasswordUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    //hashmap to store users by Id
private Map<String, User> usersById = new HashMap<>();
    //hashmap to store users by email
private Map<String, User> usersByEmail = new HashMap<>();

//method to Register a new user
    public String registerUser(String name, String email, String password){
        //email validation
        if (!isValidEmail(email)){
            return "Email is invalid";
        }
        //check email already exists/registered
        if (usersByEmail.containsKey(email)){
            return "Email already exists";
        }
        //hash password
        String hashedPassword = PasswordUtil.hashPassword(password);
        //generate unique userid
        String newUserId = UUID.randomUUID().toString();
        //create new user object named newUser
        User newUser = new User(newUserId, name, email, hashedPassword);
        //store user data in the has maps created
        usersById.put(newUserId, newUser);
        usersByEmail.put(email, newUser);
        //send success message
        return "User registered Successfully";
    }
    //method to login existing user
    public String loginUser(String email, String password){
        //email exists or no by retrieving the user by its email
        User user = usersByEmail.get(email);
        if (user == null){
            return "Email does not exists";
        }
        //hash the password
        String hashedPassword = PasswordUtil.hashPassword(password);
        //verify password
        if (!user.getPassword().equals(hashedPassword)){
            return "Invalid password";
        }
        //send success message
        return "User logged in successfully";
    }
    //Method to update user's profile
    public String UpdateUserProfile(String userId, String newName, String newEmail){
        //get user data via user id
        User user = usersById.get(userId);
        //check if user exists
        if (user == null){
            return "User does not exists";
        }
        //check if newly entered password corresponds to referring user and if not does it exists for any other user in the usersByEmail hashmap
        //meaning, check if newly entered email is registered for a different user
        if (!user.getEmail().equals(newEmail) && usersByEmail.containsKey(newEmail)){
            return "Email already exists";
        }
        //if not above 3 if conditions, then remove old email
        usersByEmail.remove(user.getEmail());

        //update user's new data
        user.setName(newName);
        user.setEmail(newEmail);

        //store user's new data to in the Hashmap with newEmail
        usersByEmail.put(newEmail, user);

        //send success message
        return "User profile updated successfully";

    }
    //method to validate email
    private boolean isValidEmail(String email){
        //regex validation logic
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
//    //method to check if email already exists
//    private boolean emailexists(String email){
//        return usersByEmail.values().stream().anyMatch(user -> user.getEmail().equals(email));
//    }
//    //method to generate userid
////    private String generateUserId(){
////        return "USER_" + (users.size() + 1);
////    }
//    //method to get user by id
//    private String getUserById(String userId){
//        return usersById.values().stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
//    }
//    //method to get user by email
//    private String getUserByEmail(String email){
//        return users.values().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
//    }
    //method to hash password
    //method to create new user
    //method to store user data
    //method to send success message
}
