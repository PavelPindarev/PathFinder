package com.example.pathfinder.model.dto.view;

import com.example.pathfinder.model.entity.Picture;

import javax.validation.constraints.Size;
import java.util.Set;

public class RouteView {
    private Long id;
    private String name;
    private String description;
    private Set<Picture> pictures;


    public RouteView() {
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

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteView setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
