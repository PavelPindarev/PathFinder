package com.example.pathfinder.web;

import com.example.pathfinder.model.dto.binding.UserLoginBindingModel;
import com.example.pathfinder.model.dto.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.dto.service.UserServiceModel;
import com.example.pathfinder.model.dto.view.UserProfileView;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    //    REGISTER
    @GetMapping("/register")
    public String getRegisterView() {
        return "register";
    }

    @ModelAttribute(name = "userModel")
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute(name = "passMatch")
    public boolean passMatch() {
        return true;
    }

    @ModelAttribute(name = "usernameExist")
    public boolean usernameExist() {
        return false;
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel registerModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        boolean passMatch = registerModel.getPassword()
                .equals(registerModel.getConfirmPassword());

        boolean usernameExist = userService.isUsernameExist(registerModel.getUsername());

        if (bindingResult.hasErrors() || !passMatch || usernameExist) {
            redirectAttributes.addFlashAttribute("userModel", registerModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            if (!passMatch) {
                redirectAttributes.addFlashAttribute("passMatch", false);
            }

            if (usernameExist) {
                redirectAttributes.addFlashAttribute("usernameExist", true);
            }

            return "redirect:register";
        }


        userService.register(mapper.map(registerModel, UserServiceModel.class));

        return "redirect:login";
    }

    //    LOGIN
    @ModelAttribute(name = "userModel")
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @ModelAttribute(name = "isExist")
    public boolean isUserExist() {
        return true;
    }

    @GetMapping("/login")
    public String getLoginView(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel bindingModel,
                        BindingResult bindingResult, RedirectAttributes redirectAttributes) {

 /*
       That is not needed right now because we don't have validations in binding model
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", bindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);

            return "redirect:login";
        }

  */
        UserServiceModel userServiceModel = userService
                .getUsersByUsernameAndPassword(bindingModel.getUsername(), bindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("isExist", false)
                    .addFlashAttribute("userLoginBindingModel", bindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult", bindingResult);

            return "redirect:login";
        }

        userService.userLogin(userServiceModel);

        return "redirect:/";
    }

    //    LOGOUT
    @GetMapping("/logout")
    public String getLogoutView() {
        userService.userLogout();
        return "redirect:/";
    }

    //    PROFILE
    @GetMapping("/profile/{id}")
    public String getProfileView(@PathVariable Long id, Model model) {
        UserProfileView profileView =
                mapper.map(userService.findById(id), UserProfileView.class);
        model.addAttribute("profileView", profileView);
        return "profile";
    }
}
