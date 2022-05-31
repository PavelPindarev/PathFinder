package com.example.pathfinder.model.dto.service;

import com.example.pathfinder.model.entity.Category;
import com.example.pathfinder.model.entity.Picture;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelType;

import java.util.Set;

public class RouteServiceModel {
    private Long id;

    private String gpxCoordinates;

    private LevelType level;

    private String name;

    private String description;

    private User author;

    private String videoUrl;

    private Set<Picture> pictures;

    private Set<Category> categories;

    public RouteServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelType getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelType level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
