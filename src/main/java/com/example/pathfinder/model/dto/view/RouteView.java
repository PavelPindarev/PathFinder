package com.example.pathfinder.model.dto.view;

import com.example.pathfinder.model.entity.Picture;


public class RouteView {
    private Long id;
    private String name;
    private String description;
    private Picture picture;


    public RouteView() {
    }

    public RouteView(Long id, String name, String description, Picture picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public RouteView setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RouteView setId(Long id) {
        this.id = id;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public RouteView setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
