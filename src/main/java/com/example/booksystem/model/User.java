package com.example.booksystem.model;

import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private String userclass;
    private String gender;
    private String telephone;
    private String department;
    private String jurisdiction;
    private String email;

    public User(String id, String username, String password, String name, String userclass, String gender, String telephone, String department, String jurisdiction, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.userclass = userclass;
        this.gender = gender;
        this.telephone = telephone;
        this.department = department;
        this.jurisdiction = jurisdiction;
        this.email = email;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserclass() {
        return userclass;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userclass='" + userclass + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", department='" + department + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
