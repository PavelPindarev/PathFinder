package com.example.pathfinder.model.dto.service;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.enums.LevelType;

import java.util.HashSet;
import java.util.Set;

public class UserServiceModel {
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private int age;

    private Set<Role> roles = new HashSet<>();

    private LevelType level;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserServiceModel setAge(int age) {
        this.age = age;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public LevelType getLevel() {
        return level;
    }

    public UserServiceModel setLevel(LevelType level) {
        this.level = level;
        return this;
    }
}
