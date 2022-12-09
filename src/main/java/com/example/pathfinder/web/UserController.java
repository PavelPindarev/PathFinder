package com.example.pathfinder.web;

import com.example.pathfinder.model.dto.binding.UserLoginBindingModel;
import com.example.pathfinder.model.dto.binding.UserRegisterBindingModel;
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

    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
    }

    //    REGISTER
    @GetMapping("/register")
    public String getRegisterView(Model model) {
        if (!model.containsAttribute("userModel")) {
            model.addAttribute("userModel", new UserRegisterBindingModel());
        }
        return "register";
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
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

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


        userService.registerAndLogin(registerModel);

        return "redirect:/";
    }

    //    LOGIN

    @GetMapping("/login")
    public String getLoginView(Model model) {
        if (!model.containsAttribute("userModel")) {
            model.addAttribute("userModel", new UserLoginBindingModel());
        }
        return "login";
    }

    //    PROFILE
    @GetMapping("/profile/{id}")
    public String getProfileView(@PathVariable Long id, Model model) {

        if (!model.containsAttribute("profileView")) {

            UserProfileView profileView = userService.findById(id);
            model.addAttribute("profileView", profileView);
        }
        return "profile";
    }
}
