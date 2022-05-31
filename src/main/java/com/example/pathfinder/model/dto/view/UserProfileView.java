package com.example.pathfinder.model.dto.view;

import com.example.pathfinder.model.entity.enums.LevelType;

public class UserProfileView {

    private Long id;

    private String username;

    private String fullName;

    private Integer age;

    private LevelType levelType;

    public UserProfileView() {
    }

    public Long getId() {
        return id;
    }

    public UserProfileView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileView setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileView setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LevelType getLevelType() {
        return levelType;
    }

    public UserProfileView setLevelType(LevelType levelType) {
        this.levelType = levelType;
        return this;
    }
}
