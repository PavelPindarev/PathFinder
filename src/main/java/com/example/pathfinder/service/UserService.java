package com.example.pathfinder.service;

import com.example.pathfinder.model.dto.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel getUsersByUsernameAndPassword(String username, String password);

    void userLogin(UserServiceModel userServiceModel);

    void userLogout();

    UserServiceModel findById(Long id);

    boolean isUsernameExist(String username);

}
