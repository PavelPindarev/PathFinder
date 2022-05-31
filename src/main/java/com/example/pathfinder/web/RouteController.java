package com.example.pathfinder.web;

import com.example.pathfinder.model.dto.view.RouteView;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final ModelMapper mapper;

    @Autowired
    public RouteController(RouteService routeService, ModelMapper mapper) {
        this.routeService = routeService;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public String getRoutesView(Model model) {
        List<RouteView> routeViews = routeService
                .getAllRoutes()
                .stream()
                .map(r -> mapper.map(r, RouteView.class))
                .collect(Collectors.toList());
        model.addAttribute("routes",  routeViews);

        return "routes";
    }
}
