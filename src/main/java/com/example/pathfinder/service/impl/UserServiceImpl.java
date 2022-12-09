package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.dto.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.dto.view.UserProfileView;
import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelType;
import com.example.pathfinder.model.entity.enums.RoleType;
import com.example.pathfinder.repository.RoleRepository;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;


    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper mapper,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void registerAndLogin(UserRegisterBindingModel registerModel) {
        User user = mapper.map(registerModel, User.class);
        Role role = roleRepository.findByName(RoleType.USER).orElseThrow();
        user.setRoles(Set.of(role));
        user.setLevel(LevelType.BEGINNER);

        user.setPassword(passwordEncoder.encode(registerModel.getPassword()));

        userRepository.save(user);

        login(user.getUsername());
    }

    private void login(String username) {
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(username);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(auth);
    }


    @Override
    public UserProfileView findById(Long id) {
        return userRepository.findById(id)
                .map(user -> mapper.map(user, UserProfileView.class))
                .orElse(null);
    }

    @Override
    public boolean isUsernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

}
