package com.example.eventmanagement.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;

    //create a constructor for User
    public User(String id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    //write getters and setters
    //getters
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
