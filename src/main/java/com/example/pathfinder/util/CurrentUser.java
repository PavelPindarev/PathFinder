package com.example.pathfinder.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;

    private String username;

    private boolean isLoggedIn;

    private boolean isAdmin;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public CurrentUser setAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }
}
