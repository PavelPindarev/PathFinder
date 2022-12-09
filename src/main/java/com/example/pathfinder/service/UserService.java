package com.example.pathfinder.service;

import com.example.pathfinder.model.dto.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.dto.view.UserProfileView;

public interface UserService {
    void registerAndLogin(UserRegisterBindingModel registerModel);

    UserProfileView findById(Long id);

    boolean isUsernameExist(String username);

}
