package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.dto.service.RouteServiceModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper mapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper mapper) {
        this.routeRepository = routeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<RouteServiceModel> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(r -> mapper.map(r, RouteServiceModel.class))
                .collect(Collectors.toList());
    }
}
