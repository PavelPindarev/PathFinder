package com.example.pathfinder.web;

import com.example.pathfinder.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PictureService pictureService;

    @Autowired
    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pictures",
                pictureService.findAllUrls());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
