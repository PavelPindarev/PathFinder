package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.dto.service.UserServiceModel;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelType;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        User user = mapper.map(userServiceModel, User.class);
        user.setLevel(LevelType.BEGINNER);

        userRepository.save(user);
    }

    @Override
    public UserServiceModel getUsersByUsernameAndPassword(String username, String password) {
        Optional<User> optUser =
                userRepository.findByUsernameAndPassword(username, password);

        return optUser
                .map(user -> mapper.map(user, UserServiceModel.class))
                .orElse(null);

    }

    @Override
    public void userLogin(UserServiceModel serviceModel) {
        this.currentUser
                .setId(serviceModel.getId())
                .setUsername(serviceModel.getUsername())
                .setLoggedIn(true);

    }

    @Override
    public void userLogout() {
        this.currentUser
                .setId(null)
                .setUsername(null)
                .setLoggedIn(false);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> mapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public boolean isUsernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

}
